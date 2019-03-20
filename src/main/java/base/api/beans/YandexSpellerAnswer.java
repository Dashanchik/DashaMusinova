package base.api.beans;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

public class YandexSpellerAnswer {

    public Integer code;
    public Integer pos;
    public Integer row;
    public Integer col;
    public Integer len;
    public String word;
    public List<String> s = new ArrayList<>();

    public YandexSpellerAnswer(){

    }

    public YandexSpellerAnswer(Integer code, String word, List<String> s) {
        this.code = code;
        this.word = word;
        this.s = s;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this).append("code", code).append("pos", pos).append("row", row).append("col", col).append("len", len).append("word", word).append("s", s).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(col).append(code).append(s).append(len).append(pos).append(row).append(word).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof YandexSpellerAnswer) == false) {
            return false;
        }
        YandexSpellerAnswer rhs = ((YandexSpellerAnswer) other);
        return new EqualsBuilder().append(code, rhs.code).append(s, rhs.s).append(word, rhs.word).isEquals();
    }

}
