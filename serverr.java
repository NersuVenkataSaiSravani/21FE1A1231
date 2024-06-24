public interface CalculatorService {
    double calculate(double height, double weight);
  }
  
  @Service
  public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public double calculate(double height, double weight) {
      if (height <= 0 || weight <= 0) {
        throw new IllegalArgumentException("Arguments must be above 0");
      }
      double heightInMeter = height / 100;
      return weight / (heightInMeter * heightInMeter);
    }
  }
  public interface CalculatorEndpoint {
    double calculate(double height, double weight);
  }
    <dependency>
        <groupId>org.apache.servicecomb</groupId>
        <artifactId>spring-boot-starter-provider</artifactId>
   </dependency>
   RestSchema(schemaId = "calculatorRestEndpoint")
@RequestMapping("/")
public class CalculatorRestEndpoint implements CalculatorEndpoint {

  private final CalculatorService calculatorService;

  @Autowired
  public CalculatorRestEndpoint(CalculatorService calculatorService) {
    this.calculatorService = calculatorService;
  }

  @Override
  @GetMapping("/guser")
  public double calculate(double height, double weight) {
    return calculatorService.calculate(height, weight);
  }
}
APPLICATION_ID: 
service_description:
  name: calculator
  version: 0.0.1
servicecomb:
  service:
    registry:
      address: http://20.244.56.144/test
  rest:
    address: 0.0.0.0:7777
    SpringBootApplication
@EnableServiceComb
public class CalculatorApplication {
  public static void main(String[] args) {
    SpringApplication.run(CalculatorApplication.class, args);
  }
}
dependency>
      <groupId>org.apache.servicecomb</groupId>
      <artifactId>spring-boot-starter-discovery</artifactId>
    </dependency>
    <dependency>
      <groupId>org.apache.servicecomb</groupId>
      <artifactId>spring-boot-starter-servicecomb</artifactId>
    </dependency>
    <dependency>
      <groupId>org.apache.servicecomb</groupId>
      <artifactId>spring-cloud-zuul</artifactId>
    </dependency>
    zuul:
  routes:
    calculator: /calculator
    APPLICATION_ID: guser
service_description:
  name: gateway
  version: 0.0.1
servicecomb:
  service:
    registry:
      address: http://20.244.50.144/test
@SpringBootApplication
@EnableZuulProxy
@EnableServiceComb
public class GatewayApplication {
  public static void main(String[] args) {
    SpringApplication.run(GatewayApplication.class, args);
  }
}
