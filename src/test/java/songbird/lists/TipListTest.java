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

        Assert.assertEquals(testList.getListField(13), expectedIndex13);
        Assert.assertEquals(testList.getListField(3), expectedIndex3);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testGetListFieldException() {
        TipList testList = new TipList();
        testList.getListField(22);
    }
}
