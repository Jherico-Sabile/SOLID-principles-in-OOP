public class OrderTest {
    public static void main(String[] args) {

        OrderCalculator calculator = new OrderCalculatorImpl();
        OrderPlacer placer = new OrderPlacerImpl();
        InvoiceGenerator invoice = new InvoiceGeneratorImpl();
        EmailNotifier email = new EmailNotifierImpl();

        OrderService orderService = new OrderService(
                calculator, placer, invoice, email
        );

        orderService.processOrder(
                10.0, 2,
                "John Doe", "123 Main St",
                "order_123.pdf",
                "johndoe@example.com"
        );
    }
}