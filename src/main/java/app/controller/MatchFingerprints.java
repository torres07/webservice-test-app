package app.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.machinezoo.sourceafis.FingerprintTemplate;

import app.model.UserDetails;
import app.model.UserDetailsSerial;

@RestController
public class MatchFingerprints {
		
	@RequestMapping("match")
	public UserDetailsSerial matchFingerprints(Model model) throws IOException {
		
		File dir = new File("/home/pedrotorres/tmp/finger_storage");
		File[] directoryList = dir.listFiles();
		
		
		List<UserDetails> candidates = new ArrayList<>();
		
		File dir_probe = new File("/home/pedrotorres/tmp/finger_probe");
		File[] directoryProbe = dir_probe.listFiles();
		
		String probePath = "";
		
		if(directoryProbe != null) {
			probePath = directoryProbe[0].getPath();
			System.out.println("probe: " + probePath);
		}
		
		
		if(directoryList != null) {
			for(int j = 0; j < directoryList.length; j++) {
				byte[] candidate = Files.readAllBytes(Paths.get(directoryList[j].getPath()));
				System.out.println(directoryList[j].getPath());
				FingerprintTemplate candidate_ = new FingerprintTemplate()
					    .dpi(500)
					    .create(candidate);
				
				UserDetails uCandidate = new UserDetails(j, directoryList[j].getName(), candidate_);
				candidates.add(uCandidate);
			}
		}
		
		System.out.println("candidatos n: " + candidates.size());
		
		UserDetailsSerial uDS = null;
		
		if(probePath != "") {
			byte[] candidateImage = Files.readAllBytes(Paths.get(probePath));
			FingerprintTemplate probe = new FingerprintTemplate()
				    .dpi(500)
				    .create(candidateImage);
			
			UserDetails uD = new UserDetails().find(probe, candidates);
			uDS = null;
			
			if(uD != null) {
				System.out.println("find!");
				uDS = new UserDetailsSerial(uD.getId(), uD.getName());
			}
			else {
				System.out.println("dont find!");
				uDS = new UserDetailsSerial(-1, "Nao encontrado");
			}
		}
		else {
			System.out.println("dont find!");
			uDS = new UserDetailsSerial(-1, "Nao encontrado.png");
		}
		
		
		return uDS;
				
	}
}
