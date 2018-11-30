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
        String expectedIndex13 = "Um lange Toene besser und  stabil zu halten, musst du kontrollierte Atmung und die richtige Tonlage verbinden.  Um zu ueben, atme tief ein und singe in einer angenehmen, mittleren Stimmlage auf La oder Du aus. Fokussiere dich auf die Stabilitaet des Tons und halte ihn solange wie moeglich. ";
        String expectedIndex3 = "Der ganze Koerper dient als Resonanzraum. Waehrend hohe Toene eher im Kopf und Oberkoerper schwingen, spuert man tiefe Toene eher im Bauch. Um zu spueren, wo die Stimme klingt, versuche zuerst so zu sprechen wie eine Hexe. Ahme danach das Lachen eines Weihnachtsmannes nach. Achte dabei darauf, wo du die Schwingungen der Stimme bemerkst. Die der Hexe muessten weiter vorne, die des Weihnachtsmannes weiter hinten im Kopf zu spueren sein. ";
        String expectedIndex0 = "Durch die richtige Atemtechnik kannst du Ueberanstrengung beim Singen  vorbeugen. Um diese zu ueben, lege deine Hand auf den Bauch.  Achte  darauf, dass deine Schultern entspannt sind und du dich nicht  verkrampfst. Atme tief ein. Wenn sich deine Bauchdecke hebt, machst du es richtig. ";

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
