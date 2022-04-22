package example
import com.amazonaws.services.secretsmanager.AWSSecretsManager
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClient
import com.amazonaws.services.secretsmanager.model._

object Main extends App {
  println(List(1, 2, 3).toString)
  val secret_name = "dev/postgres"
  val region_name = "us-west-2"

//  val secretsmanager_client = AWSSecretsManagerClient.builder.withCredentials(aws_credentials).withRegion(region).build
  val secretsmanager_client = AWSSecretsManagerClient.builder.withRegion(region_name).build

  val getSecretValueRequest = new GetSecretValueRequest().withSecretId(secret_name)
  val getSecretValueResult = secretsmanager_client.getSecretValue(getSecretValueRequest)
  val secret = getSecretValueResult.getSecretString()
  print(secret)
}
