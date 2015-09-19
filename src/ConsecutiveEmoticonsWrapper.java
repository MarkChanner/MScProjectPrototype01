/**
 * @author Mark Channer
 */
public class ConsecutiveEmoticonsWrapper {

    private FaceIcon emoticon;
    private Integer consecutiveEmotionCount;

    public ConsecutiveEmoticonsWrapper(FaceIcon emoticon, Integer consecutiveEmotions) {
        this.emoticon = emoticon;
        this.consecutiveEmotionCount = consecutiveEmotions;
    }

    public FaceIcon getEmoticon() {
        return emoticon;
    }

    public Integer getConsecutiveEmotions() {
        return consecutiveEmotionCount;
    }

}
