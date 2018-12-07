package songbird.lists;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * All variations of Strings for Alexa to say. For various IntentHandler.
 */
public class ListContainers {

    private static final int NO_TIP_LEFT_TO_SAY = -1;
    private final String[] tipList = new String[]{
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

    private Random randomGenerator = new Random();
    private static Map<Integer, Boolean> tipListMapWasTipSaid;

    private final String[] welcomeMessageList = new String[]{
            "Hei, schoen dich zu hoeren. Moechtest du heute an deiner Stimme arbeiten oder brauchst du zuerst Tipps? ",
            "Hei, schoen dass du vorbei schaust. Benoetigst du zu Beginn ein paar Tipps oder moechtest du gleich an deiner Stimme arbeiten? ",
            "Hei, schoen dass du da bist. Heute ist ein guter Tag um an deiner Stimme zu arbeiten. Moechtest du gleich los legen oder benoetigst du zu Beginn noch Tipps? ",
            "<say-as interpret-as=\"interjection\">huhu</say-as>, schoen dass du vorbeischaust. Möchtest du heute an deiner Stimme arbeiten oder brauchst du zuerst Tipps? "
    };

    private final String[] workOnVoiceList = new String[] {
            "Super. Wir beginnen mit einer Aufwaermübung um dein Zwerchfell zu trainieren. Atme tief in deinen Bauch ein und halte die Luft an fuer drei Sekunden. Nun atme langsam auf den Konsonanten F aus. Moechtest du ein Beispiel dazu hoeren? ",
            "<say-as interpret-as=\"interjection\">prima</say-as>. Lass uns mit einer Zwerchfelluebung beginnen. Atme tief in deinen Bauch ein. Halte die Luft kurz an und atme auf F mit 5 Impulsen aus. Moechtest du ein Beispiel dazu hoeren? ",
            "Perfekt, beginnen wir mit einer Zwerchfelluebung indem du tief Luft holst und diese fuer drei Sekunden haelst. Atme dann langsam auf den Konsonanten F aus. Moechtest du ein Beispiel dazu hoeren?  ",
    };

    private final String[] noExampleZwerchfellList = new String[] {
            "Wiederhole die Übung 5 mal. Wenn du die Übung beendet hast sage weiter . ",
            "Wiederhole diese Übung 5 mal. Wenn du die Übung beendet hast sage weiter. ",
    };

    private final String[] exampleZwerchfellList = new String[] {
            "Audiodatei Beispiel Zwerchfell 1-3. Wiederhole diese Uebung circa zu fuenf Mal und sage das Wort \"fertig\", sobald du fertig bist.",
            "Audiodatei Beispiel Zwerchfell 1-3. Wiederhole die Uebung fuenf Mal und gib mir mit \"fertig\" Bescheid, wenn du fertig bist.",
    };

    private final String[] questionIntervalleLaufList = new String[] {
            "Willst du nun mit Laeufen oder Intervallen fortfahren? ",
            "Moechtest du jetzt Laeufe oder Intervalle ueben? "
    };

    private final String[] explanationIntervalleList = new String[] {
            "Als Intervall bezeichnet man in der Musik den Tonhoehenabstand zwischen zwei gleichzeitig oder nacheinander erklingenden Toenen. Moechtest du nun Intervalle oder Laeufe ueben? ",
            "Intervalle sind Tonhoehenabstände zwischen zwei gleichzeitig oder aufeinanderfolgend erklingenden Toenen. Willst du nun Intervalle oder Laeufe ueben? "
    };

    private final String[] explanationLaufList = new String[] {
            "Als Lauf bezeichnet man in der Musik eine schnelle bis maeßig schnelle Tonabfolge. Oft handelt es sich dabei um Tonleitern oder Intervallen die in Halb oder Ganztoenen gespielt werden. In dieser Uebung werden die Toene einer Tonleiter auf und absteigend gespielt. Willst du nun Laeufe oder Intervalle ueben? ",
            "Laeufe sind in der Musik schnelle bis maeßig schnelle Abfolgen von Toenen. Meist sind es Tonleitern oder Intervalle, die in Halb oder Ganztoenen gespielt werden. In dieser Uebung werden die Toene einer Tonleiter auf und absteigend gespielt. Moechtest du nun Laeufe oder Intervalle ueben? "
    };

    private final String[] explainBothList = new String[] {
            "Bei Intervallen geht es in der Musik um den Tonhoehenabstand und bei Laeufen um eine schnelle Abfolge von Toenen. Als Lauf bezeichnet man in der Musik eine schnelle bis maeßig schnelle Tonabfolge. Oft handelt es sich dabei um Tonleitern oder Intervallen die in Halb oder Ganztoenen gespielt werden. Moechtest du nun Intervalle oder Laeufe ueben? ",
            "Intervalle sind Toenhoehenabstände zwischen zwei gleichzeitig oder nacheinander erklingenden Toenen und Laeufe die Abfolge von Toenen. Als Lauf bezeichnet man in der Musik eine schnelle bis maeßig schnelle Tonabfolge. Oft handelt es sich dabei um Tonleitern oder Intervallen die in Halb oder Ganztoenen gespielt werden. Moechtest du nun Intervalle oder Laeufe ueben? "
    };

    private final String[] trainLaufList = {
            "Weiter gehts. Zuerst spiele ich dir die Laeufe vor und du singst auf <break time=\"200ms\"/> H <break time=\"200ms\"/> mit. ",
            "Weiter gehts. Zuerst spiele ich dir die Laeufe vor und du singst auf <break time=\"200ms\"/> La <break time=\"200ms\"/> mit.  ",
            "Weiter gehts. Zuerst spiele ich dir die Laeufe vor und du singst auf <break time=\"200ms\"/> Mi <break time=\"200ms\"/> mit.  ",
            "Weiter gehts. Zuerst spiele ich dir die Laeufe vor und du singst auf <break time=\"200ms\"/> Lu <break time=\"200ms\"/> mit.  "
    };

    private final String trainInvertall = "Los gehts. Zuerst spiele ich dir die Intervalle vor und du steigst ein. ";

    private final String trainIntervallNotCompletedEnding = "Moechtest du nun weiter machen mit Intervallen? ";

    private final String trainLaufNotCompletedEnding = "Moechtest du nun weiter machen mit Laeufen? ";

    private final String trainIntervallLaufCompletedEnding = "Super du hast das Ende deines Traings fuer heute erreicht moechtest du zum Abschluss noch einen Tipp hoeren? ";


    /**
     * Constructor of TipList. Sets up the map for the tipList.
     */
    public ListContainers() {
        tipListMapWasTipSaid = new HashMap<>();
        for (int index = 0; index < tipList.length; ++index) {
            tipListMapWasTipSaid.put(index, false);
        }
    }

    public String getRandomWelcomeMessage() {
        return welcomeMessageList[randomGenerator.nextInt(welcomeMessageList.length)];
    }

    public String getRandomWorkOnVoiceCommand() {
        return workOnVoiceList[randomGenerator.nextInt(workOnVoiceList.length)];
    }

    public String getRandomNoExampleForZwerchfellWished() {
        return noExampleZwerchfellList[randomGenerator.nextInt(noExampleZwerchfellList.length)];
    }

    public String getRandomExampleForZwerchfellWished() {
        return exampleZwerchfellList[randomGenerator.nextInt(exampleZwerchfellList.length)];
    }

    public String getRandomQuestionIntervallOrLauf() {
        return questionIntervalleLaufList[randomGenerator.nextInt(questionIntervalleLaufList.length)];
    }

    public String getRandomExplanationForIntervall() {
        return explanationIntervalleList[randomGenerator.nextInt(explanationIntervalleList.length)];
    }

    public String getRandomExplanationForLauf() {
        return explanationLaufList[randomGenerator.nextInt(explanationLaufList.length)];
    }

    public String getRandomExplanationForBoth() {
        return explainBothList[randomGenerator.nextInt(explainBothList.length)];
    }

    public String getSampleTrainLauf() {
        return trainLaufList[randomGenerator.nextInt(trainLaufList.length)];
    }

    public String getTrainInvertallStart() {
        return trainInvertall;
    }

    public String getTrainIntervallNotCompletedEndingForLauf() {
        return trainIntervallNotCompletedEnding;
    }

    public String getTrainLaufNotCompletedEndingForIntervall() {
        return trainLaufNotCompletedEnding;
    }

    public String getTrainIntervallAndLaufCompletedEnding() {
        return trainIntervallLaufCompletedEnding;
    }

    /**
     * Returns an random tip from the list with the help of a pseudorandom Number.
     *
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
     *
     * @param index The index of the tip in the list, starting from 0.
     * @return The tip from index.
     */
    String getListField(int index) {
        if (index >= 0 && index < tipList.length) {
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
     *
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
     *
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
