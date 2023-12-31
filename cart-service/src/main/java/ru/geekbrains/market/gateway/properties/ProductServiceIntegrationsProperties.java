package ru.geekbrains.market.gateway.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;

//@ConstructorBinding
@ConfigurationProperties(prefix = "integrations.product-service")
@Data
public class ProductServiceIntegrationsProperties {
    private String url;
    private Integer connectTimeout;
    private Integer readTimeout;
    private Integer writeTimeout;
}
