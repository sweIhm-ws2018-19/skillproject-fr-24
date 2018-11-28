package songbird.lists;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TipList {

    private static final int NO_TIP_LEFT_TO_SAY = -1;
    private final String[] tipList = new String[] {
            "Durch die richtige Atemtechnik kannst du Überanstrengung beim Singen  vorbeugen. Um diese zu üben, lege deine Hand auf den Bauch.  Achte  darauf, dass deine Schultern entspannt sind und du dich nicht  verkrampfst. Atme tief ein. Wenn sich deine Bauchdecke hebt, machst du  es richtig.",
            "Der wichtigste Einatmungs-Muskel ist das Zwerchfell. Es hebt und senkt sich mit der Atmung. Je mehr Druck es dabei erzeugt, um die Luft aus den Lungen zu pressen, desto lauter wird der Ton.",
            "Verspannungen im Bereich der Gesichts- und Kaumuskulatur beeinflussen die Qualität des Stimmklanges. Zum Auflockern der Gesichtsmuskulatur kannst du zum Beispiel Gähnen, deine Wangen massieren oder deinen Kiefer kreisen.",
            "Der ganze Körper dient als Resonanzraum. Während hohe Töne eher im Kopf und Oberkörper schwingen, spürt man tiefe Töne eher im Bauch. Um zu spüren, wo die Stimme klingt, versuche zuerst so zu sprechen wie eine Hexe. Ahme danach das Lachen eines Weihnachtsmannes nach. Achte dabei darauf, wo du die Schwingungen der Stimme bemerkst. Die der Hexe müssten weiter vorne, die des Weihnachtsmannes weiter hinten im Kopf zu spüren sein.",
            "Die richtige Körperhaltung ist die Voraussetzung für gut klingende Töne und eine funktionierende Atmung. Stelle dich dafür mit beiden Füßen fest, aber entspannt hin. Die Knie sollten dabei nicht durchgestreckt sein, sondern flexibel bleiben.  Halte den Rücken gerade und die Schultern locker. Stell dir vor, dass dein Kopf und Brustbein an einem Faden aufgehängt sind.",
            "Das Gehör zu trainieren erfolgt indem man vorgegebene Töne erkennt und im Anschluss nachsingt. Zu Beginn kann diese Übung sehr schwierig erscheinen, da unser Gehör vom Alltagslärm überfordert sein kann. Gönne deinen Ohren eine Pause in der Stille und versuche im Alltag einzelne Geräusche bewusst herauszufiltern.",
            "Achte auf deine Stimme und pflege sie! Flüssigkeiten wie Wasser und Tee wirken beruhigend. Rauchen oder Schreien sind Gift für deine Stimme. Vergiss außerdem niemals dich vor jedem Gesangstraining Einzusingen!",
            "Dein psychischer Zustand beeinflusst auch deine Stimme. Die Ursache von muskulären Verkrampfungen können auch seelische Anspannungen sein. Mit Freude zu singen ist eine gute Voraussetzung, um singen zu lernen, wobei Singen auch gute Laune macht.",
            "Nur durch Training werden die Stimme und das Gehör besser. Man muss Geduld mit sich selbst haben und dran bleiben.  Nicht nur beim Singen, sondern auch in anderen Situationen wie zum Beispiel bei wichtigen Gesprächen oder Vorträgen ist es vorteilhaft, seine Stimme im Griff zu haben.",
            "Die angeborene Tonreichweite eines jeden Menschens nennt man Ambitus. Durch Übung und Unterricht kann dieser erweitert werden. Er gründet auf der entspannten Stimmlage, der Indifferenzlage. Diese ist zu erkennen, wenn du die Tonhöhe der Stimme in einem normalen Gespräch beobachtest.  In Folge kannst du daran arbeiten, die Grenzen deines Ambitus auszuweiten.",
            "Zum Auflockern, stelle dich aufrecht mit schulterbreit geöffneten Beinen hin und atme tief ein. Während des Ausatmens lasse den Oberkörper nach vorne fallen.  Lass deinen Kopf, deine Arme und Schultern locker hängen.",
            "Kreise beide Schultern langsam und entspannt ein paar Mal nach vorne. Du merkst, wie sich der obere Rücken dabei aufrichtet und der Oberkörper in sich zusammen sinkt.  Wenn du das Schulterkreisen nach hinten ausfährst, spürst du, wie sich dein Körper und dein Brustkorb stecken.",
            "Die Stimme sollte wie die Muskulatur vor dem Sport aufgewärmt werden, um einer Überlastung und eine Einschränkung der stimmlichen Qualität vorzubeugen. Das Einsingen führt zu verbesserten stimmlichen Voraussetzungen, und steigert die stimmliche Ausdrucksfähigkeit und die Freude am Singen.",
            "Um lange Töne besser und  stabil zu halten, musst du kontrollierte Atmung und die richtige Tonlage verbinden.  Um zu üben, atme tief ein und singe in einer angenehmen, mittleren Stimmlage auf ?La? oder ?Du? aus. Fokussiere dich auf die Stabilität des Tons und halte ihn solange wie möglich.",
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
