package Splitwise.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Builder
public class User {
    private String userId;
    private String name;
    private String email;
    private String phoneNumber;
    private Set<Integer> expenses;

    @Override
    public String toString() {
        return "Name: " + name + " expense ids: " + expenses;
    }
}
