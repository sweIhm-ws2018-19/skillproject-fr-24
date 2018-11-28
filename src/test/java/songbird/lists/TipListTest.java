package songbird.lists;

import org.junit.Assert;
import org.junit.Test;

public class TipListTest {

    @Test
    public void testGetRandomTip() {
        TipList testList = new TipList();
        String randomStringOne = testList.getRandomTip();
        String randomStringTwo = testList.getRandomTip();

        Assert.assertTrue(!randomStringOne.equals(randomStringTwo));
    }

    @Test
    public void testGetListField() {
        TipList testList = new TipList();
        String expectedIndex13 = "Um lange T?ne besser und  stabil zu halten, musst du kontrollierte Atmung und die richtige Tonlage verbinden.  Um zu ?ben, atme tief ein und singe in einer angenehmen, mittleren Stimmlage auf ?La? oder ?Du? aus. Fokussiere dich auf die Stabilit?t des Tons und halte ihn solange wie m?glich.";
        String expectedIndex3 = "Der ganze K?rper dient als Resonanzraum. W?hrend hohe T?ne eher im Kopf und Oberk?rper schwingen, sp?rt man tiefe T?ne eher im Bauch. Um zu sp?ren, wo die Stimme klingt, versuche zuerst so zu sprechen wie eine Hexe. Ahme danach das Lachen eines Weihnachtsmannes nach. Achte dabei darauf, wo du die Schwingungen der Stimme bemerkst. Die der Hexe m?ssten weiter vorne, die des Weihnachtsmannes weiter hinten im Kopf zu sp?ren sein.";
        String expectedIndex0 = "Durch die richtige Atemtechnik kannst du ?beranstrengung beim Singen  vorbeugen. Um diese zu ?ben, lege deine Hand auf den Bauch.  Achte  darauf, dass deine Schultern entspannt sind und du dich nicht  verkrampfst. Atme tief ein. Wenn sich deine Bauchdecke hebt, machst du  es richtig.";

        Assert.assertEquals(testList.getListField(13), expectedIndex13);
        Assert.assertEquals(testList.getListField(3), expectedIndex3);
        Assert.assertEquals(testList.getListField(0), expectedIndex0);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testGetListFieldExceptionIndexTooBig() {
        TipList testList = new TipList();
        testList.getListField(22);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testGetListFieldExceptionIndexNegative() {
        TipList testList = new TipList();
        testList.getListField(-2);
    }

    @Test
    public void testResetAllMapValues() {
        TipList testList = new TipList();

        for (int i = 0; i <= 14; ++i){
            testList.getRandomTip();
        }

        int countSaidTips = 0;
        for (int i = 0; i < 14; ++i) {
            if (testList.getValueFromMap(i)) {
                ++countSaidTips;
            }
        }

        Assert.assertEquals(countSaidTips, 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetValueFromMapExceptionIndexNegative() {
        TipList test = new TipList();
        test.getValueFromMap(-2);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetValueFromMapExceptionIndexTooBig() {
        TipList test = new TipList();
        test.getValueFromMap(44);
    }
}
