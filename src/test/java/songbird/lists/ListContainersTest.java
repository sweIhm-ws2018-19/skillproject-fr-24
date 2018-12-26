package songbird.lists;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.OngoingStubbing;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.mockito.Mockito.*;

public class ListContainersTest {

    ListContainers test;

    @Mock
    private ListContainers mockList;

    @Before
    public void setup() {
        mockList = mock(ListContainers.class);
        test = new ListContainers();
    }

    @Test
    public void testGetRandomTip() {

        String randomStringOne = test.getRandomTip();
        String randomStringTwo = test.getRandomTip();

        Assert.assertTrue(!randomStringOne.equals(randomStringTwo));
    }

    @Test
    public void testGetListField() {

        String expectedIndex6 =  " Um lange Toene besser und stabil zu halten, musst du kontrolliertes Atmen und die richtige Tonlage verbinden. Um dies zu ueben, atme tief ein und singe in einer angenehmen, mittleren Stimmlage auf La oder Du aus. Fokussiere dich auf die Stabilitaet des Tons und halte ihn solange wie moeglich. ";
        String expectedIndex3 = " Dein psychischer Zustand beeinflusst auch deine Stimme. Die Ursache von muskulaeren Verkrampfungen koennen auch seelische Anspannungen sein. Mit Freude zu singen ist eine gute Voraussetzung, um singen zu lernen. Zudem macht Singen auch gute Laune. ";
        String expectedIndex0 = " Durch die richtige Atemtechnik kannst du eine Ueberanstrengung der Stimme verhindern. Um diese zu ueben, lege deine Hand auf den Bauch. Achte darauf, dass deine Schultern entspannt sind und du dich nicht verkrampfst. Atme tief ein. Wenn sich deine Bauchdecke hebt, machst du es richtig. ";

        Assert.assertEquals(expectedIndex6, test.getListField(6));
        Assert.assertEquals(expectedIndex3, test.getListField(3));
        Assert.assertEquals(expectedIndex0, test.getListField(0));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testGetListFieldExceptionIndexTooBig() {
        test.getListField(22);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testGetListFieldExceptionIndexNegative() {
        test.getListField(-2);
    }

    @Test
    public void testResetAllMapValues() {

        for (int i = 0; i <= 7; ++i) {
            test.getRandomTip();
        }

        int countSaidTips = 0;
        for (int i = 0; i < 7; ++i) {
            if (test.getValueFromMap(i)) {
                ++countSaidTips;
            }
        }

        Assert.assertEquals(countSaidTips, 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetValueFromMapExceptionIndexNegative() {
        test.getValueFromMap(-2);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetValueFromMapExceptionIndexTooBig() {
        test.getValueFromMap(44);
    }

    @Test
    public void testGetTrainIntervallAndLaufCompletedEnding() {
        Assert.assertEquals("Super du hast das Ende deines Trainings fuer heute erreicht, moechtest du zum Abschluss noch einen Tipp hoeren? ", test.getTrainIntervallAndLaufCompletedEnding());
    }

    @Test
    public void testGetTrainLaufNotCompletedEndingForIntervall() {
        Assert.assertEquals(test.getTrainLaufNotCompletedEndingForIntervall(), "Moechtest du nun weiter machen mit Laeufen? ");
    }

    @Test
    public void testGetTrainIntervallNotCompletedEndingForLauf() {
        Assert.assertEquals(test.getTrainIntervallNotCompletedEndingForLauf(), "Moechtest du nun weiter machen mit Intervallen? ");
    }

    @Test
    public void testGetTrainInvertallStart() {
        Assert.assertEquals(test.getTrainInvertallStart(), "Los gehts. Zuerst spiele ich dir die Intervalle vor und du steigst ein. ");
    }

    @Test
    public void testGetANDSetMap() {
        Map<String, Object> testMap = new HashMap<>();
        testMap.put("0", Boolean.TRUE);
        testMap.put("1", Boolean.TRUE);
        testMap.put("2", Boolean.FALSE);
        testMap.put("3", Boolean.FALSE);
        testMap.put("4", Boolean.FALSE);
        testMap.put("5", Boolean.FALSE);
        testMap.put("6", Boolean.FALSE);
        test.setMap(testMap);
        Assert.assertEquals(test.getMap(), testMap);
    }

    @Test
    public void testGetValueFromMap() {
        boolean testValue = test.getValueFromMap(3);
        Assert.assertEquals(testValue, false);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetValueFromMapException() {
        test.getValueFromMap(10);
    }

    @Test
    public void testGetRandomTip2() {
        test.getRandomTip();
        test.getRandomTip();
        test.getRandomTip();
        test.getRandomTip();
        Assert.assertTrue(!test.getRandomTip().isEmpty());
    }

    @Test
    public void testGetSampleTrainLauf() {
        Assert.assertTrue(!test.getSampleTrainLauf().isEmpty());
    }

    @Test
    public void testGetRandomExplanationForBoth() {
        Assert.assertTrue(!test.getRandomExplanationForBoth().isEmpty());
    }

    @Test
    public void testGetRandomExplanationForLauf() {
        Assert.assertTrue(!test.getRandomExplanationForLauf().isEmpty());
    }

    @Test
    public void testGetRandomExplanationForIntervall() {
        Assert.assertTrue(!test.getRandomExplanationForIntervall().isEmpty());
    }

    @Test
    public void testGetRandomQuestionIntervallOrLauf() {
        Assert.assertTrue(!test.getRandomQuestionIntervallOrLauf().isEmpty());
    }

    @Test
    public void testGetRandomWorkOnVoiceCommand() {
        Assert.assertTrue(!test.getRandomWorkOnVoiceCommand().isEmpty());
    }

    @Test
    public void testGetRandomWelcomeMessage() {
        Assert.assertTrue(!test.getRandomWelcomeMessage().isEmpty());
    }

    @Test
    public void testGetRandomIntervall() {
        Assert.assertTrue(!test.getRandomIntervall().isEmpty());
    }

    @Test
    public void testGetRandomFarewellMessage() {
        Assert.assertTrue(!test.getRandomFarewellMessage().isEmpty());
    }
}
