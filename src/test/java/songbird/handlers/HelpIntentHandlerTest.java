package songbird.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.response.ResponseBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class HelpIntentHandlerTest {

    HelpIntentHandler handler;

    @Mock
    HandlerInput mockHandlerInput = mock(HandlerInput.class);

    @Before
    public void setUp() {
        handler = new HelpIntentHandler();
    }

    @Test
    public void testCanHandle() {
        when(mockHandlerInput.matches(any())).thenReturn(true);
        Assert.assertTrue(handler.canHandle(mockHandlerInput));
    }

    @Test
    public void testHandle() {
        when(mockHandlerInput.getResponseBuilder()).thenReturn(new ResponseBuilder());
        String actual = handler.handle(mockHandlerInput).toString();
        Assert.assertTrue(actual.contains("Du kannst mir sagen, ob du Tipps"));
    }
}