package socialnetwork.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import socialnetwork.model.user.PersonalDetails;

@Data
@AllArgsConstructor
public class UserProfile {

   private Long id;
   private String firstname;
   private String lastname;
   private String username;
   private String email;
   private PersonalDetails personalDetails;
   private String description;
   private Boolean verifiedAccount;

}
