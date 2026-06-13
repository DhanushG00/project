@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class OrderController {

    private final CartService cartService;
    private final OrderService orderService;

    // ✅ Add to Cart
    @PostMapping("/cart/{userId}")
    public ResponseEntity<CartDTO> addToCart(
            @PathVariable Long userId,
            @Valid @RequestBody CartItemDTO dto) {

        return ResponseEntity.ok(cartService.addToCart(userId, dto));
    }

    // ✅ Get Cart
    @GetMapping("/cart/{userId}")
    public ResponseEntity<CartDTO> getCart(@PathVariable Long userId) {
        return ResponseEntity.ok(cartService.getCart(userId));
    }

    // ✅ Place Order
    @PostMapping("/order/{userId}")
    public ResponseEntity<OrderDTO> placeOrder(@PathVariable Long userId) {
        return ResponseEntity.ok(orderService.placeOrder(userId));
    }
}