package com.demo.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

@Configuration
public class DynamoDBConfiguration 
{
	
	@Value("${aws.dynamodb.endpoint}")
	private String dynamoDBEndPoint;
	
	@Value("${aws.dynamodb.accessKey}")
	private String awsAccessKey;
	
	@Value("${aws.dynamodb.secretKey}")
	private String awsSecretKey;
	
	
	@Bean
	public DynamoDBMapper dynamoDBMapper()
	{
		return new DynamoDBMapper(amazonDynamoDB());
	}

	
	public AmazonDynamoDB amazonDynamoDB()
	{
		return AmazonDynamoDBClientBuilder.standard()
				.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(dynamoDBEndPoint, "eu-north-1"))
				.withCredentials(amazonDynamoDBCredentials()).build();
	}

	private AWSCredentialsProvider amazonDynamoDBCredentials()
	{
		return new AWSStaticCredentialsProvider(new BasicAWSCredentials(awsAccessKey,awsSecretKey));
	}
}
