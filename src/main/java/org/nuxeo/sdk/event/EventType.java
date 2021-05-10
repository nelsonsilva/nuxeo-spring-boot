package org.nuxeo.sdk.event;

public enum EventType {
    DOCUMENT_CREATED("documentCreated"),

    ABOUT_TO_CREATE("aboutToCreate"),

    /**
     * Empty document mode created by the DocumentModelFactory.
     * <p>
     * Useful for initialization of the fields with computed contextual data.
     */
    EMPTY_DOCUMENTMODEL_CREATED("emptyDocumentModelCreated"),

    ABOUT_TO_IMPORT("aboutToImport"),

    DOCUMENT_IMPORTED("documentImported"),

    ABOUT_TO_REMOVE("aboutToRemove"),

    DOCUMENT_REMOVED("documentRemoved"),

    DOCUMENT_TRASHED("documentTrashed"),

    DOCUMENT_UNTRASHED("documentUntrashed"),

    DOCUMENT_REMOVAL_CANCELED("documentRemovalCanceled"),

    ABOUT_TO_REMOVE_VERSION("aboutToRemoveVersion"),

    VERSION_REMOVED("versionRemoved"),

    BEFORE_DOC_UPDATE("beforeDocumentModification"),

    BEFORE_DOC_SECU_UPDATE("beforeDocumentSecurityModification"),

    DOCUMENT_UPDATED("documentModified"),

    DOCUMENT_SECURITY_UPDATED("documentSecurityUpdated"),

    DOCUMENT_LOCKED("documentLocked"),

    DOCUMENT_UNLOCKED("documentUnlocked"),

    ABOUT_TO_COPY("aboutToCopy"),

    DOCUMENT_CREATED_BY_COPY("documentCreatedByCopy"),

    DOCUMENT_DUPLICATED("documentDuplicated"),

    ABOUT_TO_MOVE("aboutToMove"),

    DOCUMENT_MOVED("documentMoved"),

    DOCUMENT_PUBLISHED("documentPublished"),

    DOCUMENT_PROXY_PUBLISHED("documentProxyPublished"),

    DOCUMENT_PROXY_UPDATED("documentProxyUpdated"),

    SECTION_CONTENT_PUBLISHED("sectionContentPublished"),

    BEFORE_DOC_RESTORE("beforeRestoringDocument"),

    DOCUMENT_RESTORED("documentRestored"),

    SESSION_SAVED("sessionSaved"),

    DOCUMENT_CHILDREN_ORDER_CHANGED("childrenOrderChanged"),

    /** This event is too general and should be used with care. */
    ABOUT_TO_CHECKOUT("aboutToCheckout"),

    /**
     * Document checked out. Listeners can increment version numbers. Listeners will be passed a pristine DocumentModel
     * where changes will not be seen by the main DocumentModel being saved.
     */
    DOCUMENT_CHECKEDOUT("documentCheckedOut"),

    /**
     * Listeners can increment version numbers. Listeners will be passed a pristine DocumentModel where changes will not
     * be seen by the main DocumentModel being saved.
     */
    INCREMENT_BEFORE_UPDATE("incrementBeforeUpdate"),

    /** This event is too general and should be used with care. */
    ABOUT_TO_CHECKIN("aboutToCheckIn"),

    /** This event is too general and should be used with care. */
    DOCUMENT_CHECKEDIN("documentCheckedIn"),

    SUBSCRIPTION_ASSIGNED("subscriptionAssigned"),

    EMAIL_DOCUMENT_SEND("emailDocumentSend"),

    /**
     * Event triggered when a personal user workspace is created
     */
    USER_WORKSPACE_CREATED("userWorkspaceCreated"),

    /**
     * A binary fulltext field has been updated.
     */
    BINARYTEXT_UPDATED("binaryTextUpdated"),

    /**
     * A blob had its digest updated.
     */
    BLOB_DIGEST_UPDATED("blobDigestUpdated"),

    /**
     * The event property containing the system property updated.
     * <p>
     * Available for the event {@link #BINARYTEXT_UPDATED}.
     */
    SYSTEM_PROPERTY("systemProperty"),

    /**
     * The event property containing the value of the system property updated.
     * <p>
     * Available for the event {@link #BINARYTEXT_UPDATED}.
     */
    SYSTEM_PROPERTY_VALUE("systemPropertyValue"),

    DOCUMENT_TAG_UPDATED("documentTagUpdated"),

    /**
     * Event triggered when one or more ACE status have been updated.
     */
    ACE_STATUS_UPDATED("ACEStatusUpdated"),

    /**
     * Event triggered when a document is about to be turned into a record.
     */
    BEFORE_MAKE_RECORD("beforeMakeRecord"),

    /**
     * Event triggered when a document has been turned into a record.
     */
    AFTER_MAKE_RECORD("afterMakeRecord"),

    /**
     * Event triggered when a retention is about to be set on a document.
     */
    BEFORE_SET_RETENTION("beforeSetRetention"),

    /**
     * Event triggered when a retention is about to be extended on a document.
     */
    BEFORE_EXTEND_RETENTION("beforeExtendRetention"),

    /**
     * Event triggered after a retention has been set on a document.
     */
    AFTER_SET_RETENTION("afterSetRetention"),

    /**
     * Event triggered after a retention has been extended on a document.
     */
    AFTER_EXTEND_RETENTION("afterExtendRetention"),

    /**
     * Event triggered (some time) after the retention of a document has expired.
     */
    RETENTION_EXPIRED("retentionExpired"),

    /**
     * Event triggered when a legal hold is about to be set on a document.
     */
    BEFORE_SET_LEGAL_HOLD("beforeSetLegalHold"),

    /**
     * Event triggered when a legal hold is about to be removed on a document.
     */
    BEFORE_REMOVE_LEGAL_HOLD("beforeRemoveLegalHold"),

    /**
     * Event triggered after a legal hold has been set on a document.
     */
    AFTER_SET_LEGAL_HOLD("afterSetLegalHold"),

    /**
     * Event triggered after a legal hold has been removed on a document.
     */
    AFTER_REMOVE_LEGAL_HOLD("afterRemoveLegalHold");

    private final String type;

    EventType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
