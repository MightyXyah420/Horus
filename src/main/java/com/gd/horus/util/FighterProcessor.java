package com.gd.horus.util;

import com.gd.horus.model.FighterInfo;
import com.gd.horus.repo.InfoRepo;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableBatchProcessing
public class FighterProcessor {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;
  
    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    @Lazy
    private InfoRepo infoRepo;

    @Bean
    public FlatFileItemReader<FighterDto> reader() {
        //Reader config
        FlatFileItemReader reader = new FlatFileItemReader<>();
        reader.setResource(new ClassPathResource("brothers.csv"));

        //line mapper config
        DefaultLineMapper lineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
        tokenizer.setDelimiter(";");
        tokenizer.setNames("fullName","doc_num","doc_type","phone","email","addr","eps","rh","contact");

        BeanWrapperFieldSetMapper fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(FighterDto.class);

        lineMapper.setFieldSetMapper(fieldSetMapper);
        lineMapper.setLineTokenizer(tokenizer);

        reader.setLineMapper(lineMapper);

        return reader;
    }
    @Bean
    public FighterItemProcessor processor(){
        return new FighterItemProcessor();
    }
    @Bean
    public RepositoryItemWriter<FighterInfo> writer() {
        RepositoryItemWriter <FighterInfo> writer = new RepositoryItemWriter<>();
        writer.setRepository(infoRepo);
        writer.setMethodName("save");
        return writer;
    }
    @Bean
    public Step step1 (ItemReader<FighterDto> itemReader, ItemWriter<FighterInfo> itemWriter){
        return this.stepBuilderFactory.get("step1").<FighterDto, FighterInfo>chunk(1).reader(itemReader)
        .processor(processor()).writer(itemWriter).build();
    }
    @Bean
    public Job brothersImportJob(JobNotificationListener listener, Step step1){
        return this.jobBuilderFactory.get("brothersImportJob").incrementer(new RunIdIncrementer())
        .listener(listener).start(step1).build();
    }
}
