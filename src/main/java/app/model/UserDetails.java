package app.model;

import com.machinezoo.sourceafis.FingerprintMatcher;
import com.machinezoo.sourceafis.FingerprintTemplate;

public class UserDetails extends UserDetailsSerial{
	private FingerprintTemplate template;
	
	public UserDetails() {	}
	
	public UserDetails(int id, String name, FingerprintTemplate template) {
		super(id, name);
		this.template = template;
	}
	
	public UserDetails find(FingerprintTemplate probe, Iterable<UserDetails> candidates) {
	    FingerprintMatcher matcher = new FingerprintMatcher()
	        .index(probe);
	    UserDetails match = null;
	    double high = 0;
	    for (UserDetails candidate : candidates) {
	        double score = matcher.match(candidate.template);
	        if (score > high) {
	            high = score;
	            match = candidate;
	        }
	    }
	    double threshold = 40;
	    return high >= threshold ? match : null;
	}
	public FingerprintTemplate getTemplate() {
		return template;
	}
	public void setTemplate(FingerprintTemplate template) {
		this.template = template;
	}
}
