package songbird.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ResumeIntentHandlerTest {

    ResumeIntentHandler handler;

    @Mock
    HandlerInput mockInputHandler = mock(HandlerInput.class);

    @Before
    public void setUp() {
        handler = new ResumeIntentHandler();
    }

    @Test
    public void testCanHandle() {
        when(mockInputHandler.matches(any())).thenReturn(true);
        Assert.assertTrue(handler.canHandle(mockInputHandler));
    }

    @Test
    public void testHandle() {
        Optional<Response> actual = handler.handle(mockInputHandler);

        Assert.assertFalse(actual.isPresent());
    }
}