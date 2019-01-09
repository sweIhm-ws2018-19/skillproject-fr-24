package songbird.handlers;

import com.amazon.ask.attributes.AttributesManager;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.Response;
import com.amazon.ask.response.ResponseBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import songbird.lists.SessionAttributeList;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class KoloraturenTrainingIntentHandlerTest {

    KoloraturenTrainingIntentHandler handler;
    Map<String, Object> sessionAttributes;

    @Mock
    HandlerInput mockInputHandler = mock(HandlerInput.class);
    AttributesManager mockAtrManager = mock(AttributesManager.class);

    @Before
    public void setUp() {
        handler = new KoloraturenTrainingIntentHandler();
        sessionAttributes = new HashMap<>();
        when(mockInputHandler.getAttributesManager()).thenReturn(mockAtrManager);
        when(mockAtrManager.getSessionAttributes()).thenReturn(sessionAttributes);
        when(mockInputHandler.getResponseBuilder()).thenReturn(new ResponseBuilder());
        when(mockInputHandler.matches(any())).thenReturn(true);
    }

    @Test
    public void testCanHandleStatusStimme() {
        sessionAttributes.put(SessionAttributeList.LAST_INTENT, SessionAttributeList.STATUS_STIMME);
        Assert.assertTrue(handler.canHandle(mockInputHandler));
    }

    @Test
    public void testCanHandleStatusHilfe() {
        sessionAttributes.put(SessionAttributeList.LAST_INTENT, SessionAttributeList.STATUS_HILFE);
        Assert.assertTrue(handler.canHandle(mockInputHandler));
    }

    @Test
    public void testCanHandleStatusIntervall() {
        sessionAttributes.put(SessionAttributeList.LAST_INTENT, SessionAttributeList.STATUS_INTERVALL);
        Assert.assertTrue(handler.canHandle(mockInputHandler));
    }

    @Test
    public void testHandle() {
        sessionAttributes.put(SessionAttributeList.IS_INTERVALL_COMPLETED, Boolean.FALSE);
        Optional<Response> actual = handler.handle(mockInputHandler);
        Assert.assertFalse(actual.toString().isEmpty());
    }
}