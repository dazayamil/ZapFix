package com.teamzapfix.zapfix.utils;

import com.teamzapfix.zapfix.exception.APIRequestException;
import com.teamzapfix.zapfix.model.entity.Client;
import com.teamzapfix.zapfix.model.enums.APIError;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class ClientSpecification {
    private static final String NAME = "name";
    private static final String PHONE = "phone";
    private static final String EMAIL = "email";
    private static final String IS_ACTIVE = "isActive";
    
    private static final Set<String> ALLOWED_KEY = Set.of(NAME, PHONE, EMAIL, IS_ACTIVE);
    
    public static Specification<Client> filter(Map<String, String> keywords) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            keywords.remove("page");
            keywords.remove("size");
            keywords.remove("sort");
            
            if (!ALLOWED_KEY.containsAll(keywords.keySet())) {
                String sb = "Invalid filter parameter: %s. Allowed parameters: %s".formatted(
                        keywords.keySet(),
                        ALLOWED_KEY
                );
                
                APIError.BAD_REQUEST.setTitle("Invalid parameter");
                APIError.BAD_REQUEST.setMessage(sb);
                throw new APIRequestException(APIError.BAD_REQUEST);
            }
            
            try {
                for (Map.Entry<String, String> entry : keywords.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    
                    if (value == null || value.trim().isEmpty()) continue;
                    
                    switch (key) {
                        case PHONE:
                            String phone = "%" + value + "%";
                            predicates.add(cb.like(cb.lower(root.get(PHONE)), phone));
                            break;
                        case EMAIL:
                            String cleanEmail = "%" + value.trim().toLowerCase() + "%";
                            predicates.add(cb.like(cb.lower(root.get(EMAIL)), cleanEmail));
                            break;
                        case NAME:
                        default:
                            String cleanName = "%" + value.trim().toLowerCase() + "%";
                            
                            predicates.add(cb.like(cb.lower(root.get(NAME)), cleanName));
                            break;
                    }
                }
            } catch (NumberFormatException ex) {
                String sb = "Invalid value for parameter: %s. Expected a number.".formatted(keywords.keySet());
                APIError.BAD_REQUEST.setTitle("Invalid value");
                APIError.BAD_REQUEST.setMessage(sb);
                throw new APIRequestException(APIError.BAD_REQUEST);
            }
            
            predicates.add(cb.isTrue(root.get(IS_ACTIVE)));
            
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}