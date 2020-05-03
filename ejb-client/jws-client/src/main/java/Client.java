import java.net.MalformedURLException;
import java.net.URL;



public class Client {


      public static void main(String[] args) throws MalformedURLException {

          private static ProductWSService service = new ProductWSService();
          public static void main(String[] args) {
              IProduct port = service.getProductWSPort();
              for(Product pr :port.getProduct()){
                  System.out.println(pr.getName());
              }
          }
      }


