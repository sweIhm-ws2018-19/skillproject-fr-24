package songbird.handlers;

import com.amazon.ask.attributes.AttributesManager;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import songbird.lists.SessionAttributeList;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IntervallTrainingIntentHandlerTest {

    IntervallTrainingIntentHandler handler;
    Map<String, Object> sessionAttributes;

    @Mock
    HandlerInput mockHandlerInput = mock(HandlerInput.class);
    AttributesManager mockAttrManager = mock(AttributesManager.class);

    @Before
    public void setUp() {
        handler = new IntervallTrainingIntentHandler();
        sessionAttributes = new HashMap<>();

        when(mockHandlerInput.getAttributesManager()).thenReturn(mockAttrManager);
        when(mockAttrManager.getSessionAttributes()).thenReturn(sessionAttributes);
    }

    @Test
    public void testCanHandleStatusStimme() {
        sessionAttributes.put(SessionAttributeList.lastIntent, SessionAttributeList.statusStimme);
        when(mockHandlerInput.matches(any())).thenReturn(true);

        Assert.assertTrue(handler.canHandle(mockHandlerInput));
    }

    @Test
    public void testCanHandleStatusHilfe() {
        sessionAttributes.put(SessionAttributeList.lastIntent, SessionAttributeList.statusHilfe);
        when(mockHandlerInput.matches(any())).thenReturn(true);

        Assert.assertTrue(handler.canHandle(mockHandlerInput));
    }

    @Test
    public void testCanHandleStatusLauefe() {
        sessionAttributes.put(SessionAttributeList.lastIntent, SessionAttributeList.statusLaufe);
        when(mockHandlerInput.matches(any())).thenReturn(true);

        Assert.assertTrue(handler.canHandle(mockHandlerInput));
    }

    @Test
    public void testHandle() {
    }
}