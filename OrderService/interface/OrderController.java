package interface;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> createOrder(@RequestBody OrderDto dto) {
        Order order = new Order(UUID.randomUUID());
        service.placeOrder(order);
        return ResponseEntity.ok().build();
    }
}
