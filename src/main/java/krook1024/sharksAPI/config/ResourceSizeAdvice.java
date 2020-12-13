package krook1024.sharksAPI.config;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Collection;

@ControllerAdvice
public class ResourceSizeAdvice implements ResponseBodyAdvice<Collection<?>> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        //Checks if this advice is applicable.
        //In this case it applies to any endpoint which returns a collection.
        return Collection.class.isAssignableFrom(returnType.getParameterType());
    }

    @Override
    public Collection<?> beforeBodyWrite(Collection<?> objects, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, org.springframework.http.server.ServerHttpRequest serverHttpRequest, org.springframework.http.server.ServerHttpResponse serverHttpResponse) {
        serverHttpResponse.getHeaders().add("X-Total-Count", String.valueOf(objects.size()));
        return objects;
    }
}
