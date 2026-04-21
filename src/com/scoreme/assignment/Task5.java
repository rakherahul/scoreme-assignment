package com.scoreme.assignment;

import java.util.List;

public class Task5 {

    private static final Logger logger = LoggerFactory.getLogger(Task5.class);

    public ValidationResult validate(Document doc) {
        try {
            if (doc == null) {
                // FIX: return validation result instead of throwing exception
                return ValidationResult.invalid("Document is null");
            }

            String content = doc.extractContent();

            if (content == null || content.isEmpty()) {
                // FIX: treat validation failure as normal case
                return ValidationResult.invalid("Empty content");
            }

            return runValidationRules(content);

        } catch (Exception e) {
            // FIX: proper logging instead of printStackTrace
            logger.error("Unexpected error during validation", e);

            // FIX: avoid returning null
            return ValidationResult.invalid("Internal validation error");
        }
    }

    public void validateBatch(List<Document> docs) {
        for (Document doc : docs) {
            try {
                ValidationResult r = validate(doc);

                // FIX: null-safe check
                if (r != null && r.isValid()) {
                    saveResult(r);
                }

            } catch (Exception e) {
                // FIX: do not silently swallow exception
                logger.error("Error processing document in batch", e);
            }
        }
    }

    private ValidationResult runValidationRules(String content) {
        return new ValidationResult(); // dummy
    }

    private void saveResult(ValidationResult r) {
        // dummy
    }
}