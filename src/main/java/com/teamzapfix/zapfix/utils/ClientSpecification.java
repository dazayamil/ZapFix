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
import java.util.stream.Collectors;

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
            
            
            Map<String, String> cleanKeywords = keywords.entrySet()
                                                        .stream()
                                                        .filter(entry -> entry.getValue() != null &&
                                                                !entry.getValue().trim().isEmpty() &&
                                                                !"null".equals(entry.getValue()))
                                                        .collect(Collectors.toMap(
                                                                Map.Entry::getKey,
                                                                Map.Entry::getValue
                                                        ));
            
            if (!ALLOWED_KEY.containsAll(cleanKeywords.keySet())) {
                String sb = "Invalid filter parameter: %s. Allowed parameters: %s".formatted(
                        keywords.keySet(),
                        ALLOWED_KEY
                );
                
                APIError.BAD_REQUEST.setTitleKey("Invalid parameter");
                APIError.BAD_REQUEST.setMessageKey(sb);
                throw new APIRequestException(APIError.BAD_REQUEST);
            }
            
            
            cleanKeywords.forEach((key, value) -> {
                String text = "%" + value.toLowerCase() + "%";
                
                switch (key) {
                    case PHONE -> predicates.add(cb.like(cb.lower(root.get(PHONE)), text));
                    case EMAIL -> predicates.add(cb.like(cb.lower(root.get(EMAIL)), text));
                    case NAME -> predicates.add(cb.like(cb.lower(root.get(NAME)), text));
                }
            });
            
            predicates.add(cb.isTrue(root.get(IS_ACTIVE)));
            
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}