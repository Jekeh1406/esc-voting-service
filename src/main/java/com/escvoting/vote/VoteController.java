package com.escvoting.vote;

import com.escvoting.music.Music;
import com.escvoting.music.MusicRepository;
import com.escvoting.user.User;
import com.escvoting.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/votes")
public class VoteController {

    private final VoteService voteService;
    private final UserRepository userRepository;
    private final MusicRepository musicRepository;

    @Autowired
    public VoteController(VoteService voteService, UserRepository userRepository, MusicRepository musicRepository) {
        this.voteService = voteService;
        this.userRepository = userRepository;
        this.musicRepository = musicRepository;
    }

    @PostMapping
    public ResponseEntity<?> createVote(@RequestBody VoteDTO voteDTO) {
        try {
            User user = userRepository.findById( (long) voteDTO.getUserId())
                    .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
            Music music = musicRepository.findById( (long) voteDTO.getMusicId())
                    .orElseThrow(() -> new RuntimeException("Musique non trouvée"));

            Vote vote = voteService.createVote(
                    user,
                    music,
                    voteDTO.getMusicNote(),
                    voteDTO.getVoiceNote(),
                    voteDTO.getInterpretationNote(),
                    voteDTO.getShowNote()
            );

            return ResponseEntity.ok(vote);
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erreur lors de la création du vote");
        }
    }
}
