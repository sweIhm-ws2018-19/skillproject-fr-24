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
        String actual = handler.handle(mockInputHandler).toString();
        Assert.assertFalse(actual.isEmpty());
        Assert.assertTrue(actual.contains("Bis bald")
                || actual.contains("Bis zum naechsten Mal")
                || actual.contains("Wir hoeren voneinander")
                || actual.contains("Servus")
                || actual.contains("Adieu")
                || actual.contains("Hoffentlich bis morgen")
                || actual.contains("Hasta la vista")
                || actual.contains("Ich hoffe wir hoeren uns morgen")
                || actual.contains("Komm morgen wieder vorbei"));
    }
}
