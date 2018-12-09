package songbird.lists;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TipList {

    private static final int NO_TIP_LEFT_TO_SAY = -1;
    private final String[] tipList = new String[] {
            "Durch die richtige Atemtechnik kannst du Ueberanstrengung beim Singen  vorbeugen. Um diese zu ueben, lege deine Hand auf den Bauch.  Achte  darauf, dass deine Schultern entspannt sind und du dich nicht  verkrampfst. Atme tief ein. Wenn sich deine Bauchdecke hebt, machst du es richtig. ",
            "Der wichtigste Einatmungs-Muskel ist das Zwerchfell. Es hebt und senkt sich mit der Atmung. Je mehr Druck es dabei erzeugt, um die Luft aus den Lungen zu pressen, desto lauter wird der Ton. ",
            "Verspannungen im Bereich der Gesichts- und Kaumuskulatur beeinflussen die Qualitaet des Stimmklanges. Zum Auflockern der Gesichtsmuskulatur kannst du zum Beispiel Gaehnen, deine Wangen massieren oder deinen Kiefer kreisen. ",
            "Der ganze Koerper dient als Resonanzraum. Waehrend hohe Toene eher im Kopf und Oberkoerper schwingen, spuert man tiefe Toene eher im Bauch. Um zu spueren, wo die Stimme klingt, versuche zuerst so zu sprechen wie eine Hexe. Ahme danach das Lachen eines Weihnachtsmannes nach. Achte dabei darauf, wo du die Schwingungen der Stimme bemerkst. Die der Hexe muessten weiter vorne, die des Weihnachtsmannes weiter hinten im Kopf zu spueren sein. ",
            "Die richtige Koerperhaltung ist die Voraussetzung fuer gut klingende Toene und eine funktionierende Atmung. Stelle dich dafuer mit beiden Fueßen fest, aber entspannt hin. Die Knie sollten dabei nicht durchgestreckt sein, sondern flexibel bleiben.  Halte den Ruecken gerade und die Schultern locker. Stell dir vor, dass dein Kopf und Brustbein an einem Faden aufgehaengt sind. ",
            "Das Gehoer zu trainieren erfolgt indem man vorgegebene Toene erkennt und im Anschluss nachsingt. Zu Beginn kann diese Uebung sehr schwierig erscheinen, da unser Gehoer vom Alltagslaerm ueberfordert sein kann. Goenne deinen Ohren eine Pause in der Stille und versuche im Alltag einzelne Geraeusche bewusst herauszufiltern. ",
            "Achte auf deine Stimme und pflege sie! Fluessigkeiten wie Wasser und Tee wirken beruhigend. Rauchen oder Schreien sind Gift fuer deine Stimme. Vergiss außerdem niemals dich vor jedem Gesangstraining Einzusingen! ",
            "Dein psychischer Zustand beeinflusst auch deine Stimme. Die Ursache von muskulaeren Verkrampfungen koennen auch seelische Anspannungen sein. Mit Freude zu singen ist eine gute Voraussetzung, um singen zu lernen, wobei Singen auch gute Laune macht. ",
            "Nur durch Training werden die Stimme und das Gehoer besser. Man muss Geduld mit sich selbst haben und dran bleiben.  Nicht nur beim Singen, sondern auch in anderen Situationen wie zum Beispiel bei wichtigen Gespraechen oder Vortraegen ist es vorteilhaft, seine Stimme im Griff zu haben. ",
            "Die angeborene Tonreichweite eines jeden Menschens nennt man Ambitus. Durch Uebung und Unterricht kann dieser erweitert werden. Er gruendet auf der entspannten Stimmlage, der Indifferenzlage. Diese ist zu erkennen, wenn du die Tonhoehe der Stimme in einem normalen Gespraech beobachtest.  In Folge kannst du daran arbeiten, die Grenzen deines Ambitus auszuweiten. ",
            "Zum Auflockern, stelle dich aufrecht mit schulterbreit geoeffneten Beinen hin und atme tief ein. Waehrend des Ausatmens lasse den Oberkoerper nach vorne fallen.  Lass deinen Kopf, deine Arme und Schultern locker haengen. ",
            "Kreise beide Schultern langsam und entspannt ein paar Mal nach vorne. Du merkst, wie sich der obere Ruecken dabei aufrichtet und der Oberkoerper in sich zusammen sinkt.  Wenn du das Schulterkreisen nach hinten ausfaehrst, spuerst du, wie sich dein Koerper und dein Brustkorb stecken. ",
            "Die Stimme sollte wie die Muskulatur vor dem Sport aufgewaermt werden, um einer Ueberlastung und eine Einschraenkung der stimmlichen Qualitaet vorzubeugen. Das Einsingen fuehrt zu verbesserten stimmlichen Voraussetzungen, und steigert die stimmliche Ausdrucksfaehigkeit und die Freude am Singen. ",
            "Um lange Toene besser und  stabil zu halten, musst du kontrollierte Atmung und die richtige Tonlage verbinden.  Um zu ueben, atme tief ein und singe in einer angenehmen, mittleren Stimmlage auf La oder Du aus. Fokussiere dich auf die Stabilitaet des Tons und halte ihn solange wie moeglich. ",
    };

    private final String[] intervallTrainingPlaylist = new String[] {
            "<audio src=\"https://s3.amazonaws.com/songbirdrolebucket/Intervall/int_9.mp3\"/>",
            "<audio src=\"https://s3.amazonaws.com/songbirdrolebucket/Intervall/int_10.mp3\"/>",
            "<audio src=\"https://s3.amazonaws.com/songbirdrolebucket/Intervall/int_11.mp3\"/>",
            "<audio src=\"https://s3.amazonaws.com/songbirdrolebucket/Intervall/int_12.mp3\"/>",
            "<audio src=\"https://s3.amazonaws.com/songbirdrolebucket/Intervall/int_13.mp3\"/>",
            "<audio src=\"https://s3.amazonaws.com/songbirdrolebucket/Intervall/int_14.mp3\"/>",
            "<audio src=\"https://s3.amazonaws.com/songbirdrolebucket/Intervall/int_15.mp3\"/>",
            "<audio src=\"https://s3.amazonaws.com/songbirdrolebucket/Intervall/int_16.mp3\"/>",
            "<audio src=\"https://s3.amazonaws.com/songbirdrolebucket/Intervall/int_17.mp3\"/>",
            "<audio src=\"https://s3.amazonaws.com/songbirdrolebucket/Intervall/int_18.mp3\"/>",
            "<audio src=\"https://s3.amazonaws.com/songbirdrolebucket/Intervall/int_19.mp3\"/>",
            "<audio src=\"https://s3.amazonaws.com/songbirdrolebucket/Intervall/int_20.mp3\"/>",
            "<audio src=\"https://s3.amazonaws.com/songbirdrolebucket/Intervall/int_qua.mp3\"/>",
            "<audio src=\"https://s3.amazonaws.com/songbirdrolebucket/Intervall/int_qui.mp3\"/>",
            "<audio src=\"https://s3.amazonaws.com/songbirdrolebucket/Intervall/int_oktave.mp3\"/>",
            "<audio src=\"https://s3.amazonaws.com/songbirdrolebucket/Intervall/int_sept.mp3\"/>",
            "<audio src=\"https://s3.amazonaws.com/songbirdrolebucket/Intervall/int_sex.mp3\"/>",
            "<audio src=\"https://s3.amazonaws.com/songbirdrolebucket/Intervall/int_sek.mp3\"/>",
            "<audio src=\"https://s3.amazonaws.com/songbirdrolebucket/Intervall/int_ter.mp3\"/>",
    };

    private Random randomGenerator = new Random();
    private static Map<Integer, Boolean> tipListMapWasTipSaid;
    private static Map<Integer, Boolean> intervallTrainingUsed;

    /**
     * Constructor of TipList. Sets up the map for the tipList.
         */
    public TipList() {
        tipListMapWasTipSaid = new HashMap<>();
        intervallTrainingUsed = new HashMap<>();
        for (int index = 0; index < tipList.length; ++index) {
            tipListMapWasTipSaid.put(index, false);
        }
        for (int index = 0; index < intervallTrainingPlaylist.length; ++index) {
            intervallTrainingUsed.put(index, false);
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
