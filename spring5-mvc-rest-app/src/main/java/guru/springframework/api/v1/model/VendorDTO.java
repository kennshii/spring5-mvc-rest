package guru.springframework.api.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendorDTO {

    @ApiModelProperty(value = "name", required = true)
    private String name;

    @ApiModelProperty(value = "url", required = true)
    @JsonProperty("vendor_url")
    private String vendorUrl;
}
