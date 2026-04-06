public class OrderService {

    private OrderCalculator calculator;
    private OrderPlacer placer;
    private InvoiceGenerator invoiceGenerator;
    private EmailNotifier emailNotifier;

    public OrderService(OrderCalculator calculator,
                        OrderPlacer placer,
                        InvoiceGenerator invoiceGenerator,
                        EmailNotifier emailNotifier) {
        this.calculator = calculator;
        this.placer = placer;
        this.invoiceGenerator = invoiceGenerator;
        this.emailNotifier = emailNotifier;
    }

    public void processOrder(double price, int quantity,
                             String customerName, String address,
                             String fileName, String email) {

        calculator.calculateTotal(price, quantity);
        placer.placeOrder(customerName, address);
        invoiceGenerator.generateInvoice(fileName);
        emailNotifier.sendEmailNotification(email);
    }
}