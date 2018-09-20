package example.code.leastfm.model.apipojos;

import com.google.gson.annotations.SerializedName;

public class Model {
    private Results results;

    @SerializedName("results")
    public Results getResults() {
        return results;
    }

    public void setResults(Results results) {
        this.results = results;
    }
}
