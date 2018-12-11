package songbird.lists;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.OngoingStubbing;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

public class ListContainersTest {

    @Mock private ListContainers mockList;

    @Before public void setup() {
        mockList = mock(ListContainers.class);
    }

    @Test
    public void testGetRandomTip() {
        ListContainers testList = new ListContainers();
        String randomStringOne = testList.getRandomTip();
        String randomStringTwo = testList.getRandomTip();

        Assert.assertTrue(!randomStringOne.equals(randomStringTwo));
    }

    @Test
    public void testGetListField() {
        ListContainers testList = new ListContainers();
        String expectedIndex6 = " Um lange Toene besser und  stabil zu halten, musst du kontrolliertes Atmen  und die richtige Tonlage verbinden. Um dies  zu ueben, atme tief ein und singe in einer angenehmen, mittleren Stimmlage auf La oder Du aus. Fokussiere dich auf die Stabilitaet des Tons und halte ihn solange wie moeglich. ";
        String expectedIndex3 = " Dein psychischer Zustand beeinflusst auch deine Stimme. Die Ursache von muskulaeren Verkrampfungen koennen auch seelische Anspannungen sein. Mit Freude zu singen ist eine gute Voraussetzung, um singen zu lernen. Zudem macht Singen auch gute Laune. ";
        String expectedIndex0 = " Durch die richtige Atemtechnik kannst du eine Ueberanstrengung der Stimme vehindern. Um diese zu ueben, lege deine Hand auf den Bauch. Achte darauf, dass deine Schultern entspannt sind und du dich nicht verkrampfst. Atme tief ein. Wenn sich deine Bauchdecke hebt, machst du es richtig. ";

        Assert.assertEquals(testList.getListField(6), expectedIndex6);
        Assert.assertEquals(testList.getListField(3), expectedIndex3);
        Assert.assertEquals(testList.getListField(0), expectedIndex0);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testGetListFieldExceptionIndexTooBig() {
        ListContainers testList = new ListContainers();
        testList.getListField(22);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testGetListFieldExceptionIndexNegative() {
        ListContainers testList = new ListContainers();
        testList.getListField(-2);
    }

    @Test
    public void testResetAllMapValues() {
        ListContainers testList = new ListContainers();

        for (int i = 0; i <= 7; ++i){
            testList.getRandomTip();
        }

        int countSaidTips = 0;
        for (int i = 0; i < 7; ++i) {
            if (testList.getValueFromMap(i)) {
                ++countSaidTips;
            }
        }

        Assert.assertEquals(countSaidTips, 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetValueFromMapExceptionIndexNegative() {
        ListContainers test = new ListContainers();
        test.getValueFromMap(-2);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetValueFromMapExceptionIndexTooBig() {
        ListContainers test = new ListContainers();
        test.getValueFromMap(44);
    }

    @Test
    public void testGetTrainIntervallAndLaufCompletedEnding() {
        ListContainers test = new ListContainers();
        Assert.assertEquals(test.getTrainIntervallAndLaufCompletedEnding(), "Super du hast das Ende deines Trainings fuer heute erreicht moechtest du zum Abschluss noch einen Tipp hoeren? ");
    }

    @Test
    public void testGetTrainLaufNotCompletedEndingForIntervall() {
        ListContainers test = new ListContainers();
        Assert.assertEquals(test.getTrainLaufNotCompletedEndingForIntervall(), "Moechtest du nun weiter machen mit Laeufen? ");
    }

    @Test
    public void testGetTrainIntervallNotCompletedEndingForLauf() {
        ListContainers test = new ListContainers();
        Assert.assertEquals(test.getTrainIntervallNotCompletedEndingForLauf(), "Moechtest du nun weiter machen mit Intervallen? ");
    }

    @Test
    public void testGetTrainInvertallStart() {
        ListContainers test = new ListContainers();
        Assert.assertEquals(test.getTrainInvertallStart(), "Los gehts. Zuerst spiele ich dir die Intervalle vor und du steigst ein. ");
    }

}
