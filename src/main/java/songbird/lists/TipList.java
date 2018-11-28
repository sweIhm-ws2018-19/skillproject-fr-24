package songbird.lists;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TipList {

    private static final int NO_TIP_LEFT_TO_SAY = -1;
    private final String[] tipList = new String[] {
            "Durch die richtige Atemtechnik kannst du ?beranstrengung beim Singen  vorbeugen. Um diese zu ?ben, lege deine Hand auf den Bauch.  Achte  darauf, dass deine Schultern entspannt sind und du dich nicht  verkrampfst. Atme tief ein. Wenn sich deine Bauchdecke hebt, machst du  es richtig.",
            "Der wichtigste Einatmungs-Muskel ist das Zwerchfell. Es hebt und senkt sich mit der Atmung. Je mehr Druck es dabei erzeugt, um die Luft aus den Lungen zu pressen, desto lauter wird der Ton.",
            "Verspannungen im Bereich der Gesichts- und Kaumuskulatur beeinflussen die Qualit?t des Stimmklanges. Zum Auflockern der Gesichtsmuskulatur kannst du zum Beispiel G?hnen, deine Wangen massieren oder deinen Kiefer kreisen.",
            "Der ganze K?rper dient als Resonanzraum. W?hrend hohe T?ne eher im Kopf und Oberk?rper schwingen, sp?rt man tiefe T?ne eher im Bauch. Um zu sp?ren, wo die Stimme klingt, versuche zuerst so zu sprechen wie eine Hexe. Ahme danach das Lachen eines Weihnachtsmannes nach. Achte dabei darauf, wo du die Schwingungen der Stimme bemerkst. Die der Hexe m?ssten weiter vorne, die des Weihnachtsmannes weiter hinten im Kopf zu sp?ren sein.",
            "Die richtige K?rperhaltung ist die Voraussetzung f?r gut klingende T?ne und eine funktionierende Atmung. Stelle dich daf?r mit beiden F??en fest, aber entspannt hin. Die Knie sollten dabei nicht durchgestreckt sein, sondern flexibel bleiben.  Halte den R?cken gerade und die Schultern locker. Stell dir vor, dass dein Kopf und Brustbein an einem Faden aufgeh?ngt sind.",
            "Das Geh?r zu trainieren erfolgt indem man vorgegebene T?ne erkennt und im Anschluss nachsingt. Zu Beginn kann diese ?bung sehr schwierig erscheinen, da unser Geh?r vom Alltagsl?rm ?berfordert sein kann. G?nne deinen Ohren eine Pause in der Stille und versuche im Alltag einzelne Ger?usche bewusst herauszufiltern.",
            "Achte auf deine Stimme und pflege sie! Fl?ssigkeiten wie Wasser und Tee wirken beruhigend. Rauchen oder Schreien sind Gift f?r deine Stimme. Vergiss au?erdem niemals dich vor jedem Gesangstraining Einzusingen!",
            "Dein psychischer Zustand beeinflusst auch deine Stimme. Die Ursache von muskul?ren Verkrampfungen k?nnen auch seelische Anspannungen sein. Mit Freude zu singen ist eine gute Voraussetzung, um singen zu lernen, wobei Singen auch gute Laune macht.",
            "Nur durch Training werden die Stimme und das Geh?r besser. Man muss Geduld mit sich selbst haben und dran bleiben.  Nicht nur beim Singen, sondern auch in anderen Situationen wie zum Beispiel bei wichtigen Gespr?chen oder Vortr?gen ist es vorteilhaft, seine Stimme im Griff zu haben.",
            "Die angeborene Tonreichweite eines jeden Menschens nennt man Ambitus. Durch ?bung und Unterricht kann dieser erweitert werden. Er gr?ndet auf der entspannten Stimmlage, der Indifferenzlage. Diese ist zu erkennen, wenn du die Tonh?he der Stimme in einem normalen Gespr?ch beobachtest.  In Folge kannst du daran arbeiten, die Grenzen deines Ambitus auszuweiten.",
            "Zum Auflockern, stelle dich aufrecht mit schulterbreit ge?ffneten Beinen hin und atme tief ein. W?hrend des Ausatmens lasse den Oberk?rper nach vorne fallen.  Lass deinen Kopf, deine Arme und Schultern locker h?ngen.",
            "Kreise beide Schultern langsam und entspannt ein paar Mal nach vorne. Du merkst, wie sich der obere R?cken dabei aufrichtet und der Oberk?rper in sich zusammen sinkt.  Wenn du das Schulterkreisen nach hinten ausf?hrst, sp?rst du, wie sich dein K?rper und dein Brustkorb stecken.",
            "Die Stimme sollte wie die Muskulatur vor dem Sport aufgew?rmt werden, um einer ?berlastung und eine Einschr?nkung der stimmlichen Qualit?t vorzubeugen. Das Einsingen f?hrt zu verbesserten stimmlichen Voraussetzungen, und steigert die stimmliche Ausdrucksf?higkeit und die Freude am Singen.",
            "Um lange T?ne besser und  stabil zu halten, musst du kontrollierte Atmung und die richtige Tonlage verbinden.  Um zu ?ben, atme tief ein und singe in einer angenehmen, mittleren Stimmlage auf ?La? oder ?Du? aus. Fokussiere dich auf die Stabilit?t des Tons und halte ihn solange wie m?glich.",
    };

    private Random randomGenerator = new Random();
    private static Map<Integer, Boolean> tipListMapWasTipSaid;

    /**
     * Constructor of TipList. Sets up the map for the tipList.
     */
    public TipList() {
        tipListMapWasTipSaid = new HashMap<>();
        for (int index = 0; index < tipList.length; ++index) {
            tipListMapWasTipSaid.put(index, false);
        }
    }

    /**
     * Returns an random tip from the list with the help of a pseudorandom Number.
     * @return A random tip from the list.
     */
    public String getRandomTip() {
        int randomInt = randomGenerator.nextInt(tipList.length);

        if (tipListMapWasTipSaid.get(randomInt)) {
            randomInt = getIndexFromUnsaidTip();
        }
        if (randomInt == NO_TIP_LEFT_TO_SAY) {
            resetAllMapValues();
            randomInt = randomGenerator.nextInt(tipList.length);
        }

        tipListMapWasTipSaid.replace(randomInt, true);

        return tipList[randomInt];
    }

    /**
     * Access an specific field from the list. Index can only be between 0 and 13!
     * @param index The index of the tip in the list, starting from 0.
     * @return The tip from index.
     */
     String getListField(int index) {
        if ( index >= 0 && index < tipList.length) {
            return tipList[index];
        } else {
            throw new ArrayIndexOutOfBoundsException("Index can only be between 0 and 13!");
        }
    }

    /**
     * This method sets all values of the Map tipListMap... to false -> items were not said.
     * To use, when all tips were read.
     */
    private void resetAllMapValues() {
         for (int index = 0; index < tipList.length; ++index) {
             tipListMapWasTipSaid.replace(index, false);
         }
    }

    /**
     * Get an index for the tipList, that was not used by the AlexaSkill.
     * @return Get the index or a negative Number, if everything was said.
     */
    private int getIndexFromUnsaidTip() {
        return tipListMapWasTipSaid.entrySet().stream().
                filter(s -> !s.getValue()).
                map(Map.Entry::getKey).
                findAny().orElse(NO_TIP_LEFT_TO_SAY);
    }

    /**
     * Getter Method to get the information, if the list element on the index was said or not.
     * @param index index from the list, to check the fitting value.
     * @return if the tip from this index was said or not.
     */
    public boolean getValueFromMap(int index) {
        if (index >= 0 && index < tipList.length) {
            return tipListMapWasTipSaid.get(index);
        } else {
            throw new IndexOutOfBoundsException("Index can only be between 0 and 13");
        }
    }
}
