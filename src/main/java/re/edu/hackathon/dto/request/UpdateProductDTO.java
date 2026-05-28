package re.edu.hackathon.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UpdateProductDTO {
    @NotBlank(message = "mã sản phẩm không được trống")
    private String code;
    @NotBlank(message = "tên sản phẩm không được trống")
    private String name;
    @NotBlank(message = "sku không được trống")
    private String sku;
    @NotBlank(message = "mô tả sản phẩm không được trống")
    private String description;
    @NotBlank(message = "số lượng tồn kho không được trống")
    @Min(value = 0, message = "số lượng tồn kho phải lớn hơn 0")
    private String stockQuantity;
    @NotNull(message = "giá sản phẩm không được trống")
    private Double price;
    @NotBlank(message = "danh mục không được để trống")
    private String category;
    @NotBlank(message = "cân nặng không được để trống")
    private String weight;
    @NotBlank(message = "trạng thái không được để trống")
    private String status;
}
