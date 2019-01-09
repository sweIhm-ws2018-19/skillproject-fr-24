package songbird.handlers;

import com.amazon.ask.attributes.AttributesManager;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.response.ResponseBuilder;
import org.junit.Before;
import org.mockito.Mock;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import org.junit.Test;
import static org.mockito.Mockito.when;

public class LaunchRequestHandlerTest {

    LaunchRequestHandler handler;

    @Mock
    HandlerInput mockInputHandler = mock(HandlerInput.class);

    @Before
    public void setUp() {
        handler = new LaunchRequestHandler();
        when(mockInputHandler.getResponseBuilder()).thenReturn(new ResponseBuilder());
        when(mockInputHandler.matches(any())).thenReturn(true);
    }

    @Test
    public void testCanHandle() {
        Assert.assertTrue(handler.canHandle(mockInputHandler));
    }
}