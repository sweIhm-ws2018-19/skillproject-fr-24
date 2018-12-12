package songbird.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.response.ResponseBuilder;
import org.junit.*;
import org.mockito.*;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class CancelandStopIntentHandlerTest {

    CancelandStopIntentHandler handler;

    @Mock
    HandlerInput mockInputHandler = mock(HandlerInput.class);

    @Before
    public void setup() {
        handler = new CancelandStopIntentHandler();
    }

    @Test
    public void testCanHandle() {
        when(mockInputHandler.matches(any())).thenReturn(true);

        Assert.assertTrue(handler.canHandle(mockInputHandler));
    }

    @Test
    public void testHandle() {
        when(mockInputHandler.getResponseBuilder()).thenReturn(new ResponseBuilder());

        Assert.assertTrue(handler.handle(mockInputHandler).toString().contains("Auf Wiedersehen"));
    }
}
