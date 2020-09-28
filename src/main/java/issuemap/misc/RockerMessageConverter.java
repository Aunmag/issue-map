package issuemap.misc;

import com.fizzed.rocker.RockerModel;
import com.fizzed.rocker.runtime.OutputStreamOutput;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class RockerMessageConverter extends AbstractHttpMessageConverter<RockerModel> {

    public RockerMessageConverter() {
        super(StandardCharsets.UTF_8, MediaType.TEXT_HTML);
    }

    @Override
    protected boolean supports(Class<?> cls) {
        return RockerModel.class.isAssignableFrom(cls);
    }

    @Override
    protected void writeInternal(RockerModel model, HttpOutputMessage output) throws IOException, HttpMessageNotWritableException {
        var body = output.getBody();
        model.render((contentType, charset) -> new OutputStreamOutput(contentType, body, charset));
    }

    @Override
    public boolean canRead(Class<?> clazz, MediaType mediaType) {
        return false;
    }

    @Override
    protected RockerModel readInternal(Class<? extends RockerModel> cls, HttpInputMessage message) throws HttpMessageNotReadableException {
        throw new HttpMessageNotReadableException("Input not supported by Rocker", message);
    }

}
