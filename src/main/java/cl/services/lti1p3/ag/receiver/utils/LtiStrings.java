//*********************************************************************
//
//                       Copyright (C) 2022-2022
//                       Carnegie Learning Inc.
//
//                       All Rights Reserved.
//
//This program is the subject of trade secrets and intellectual
//property rights owned by Carnegie Learning.
//
//This legend must continue to appear in the source code despite
//modifications or enhancements by any party.
//
//*********************************************************************
package cl.services.lti1p3.ag.receiver.utils;

import java.util.Arrays;
import java.util.List;

public class LtiStrings {
	

    public static final int ROLE_STUDENT = 0;
    public static final int ROLE_INSTRUCTOR = 1;
    
    // OIDC Initiation Parameters
    public static final String OIDC_NONE = "none";
    public static final String OIDC_FORM_POST = "form_post";
    public static final String OIDC_ID_TOKEN = "id_token";
    public static final String OIDC_OPEN_ID = "openid";
    public static final String OIDC_LOGIN_HINT = "login_hint";
    public static final String OIDC_LOGIN_HINT_ID = "userId";
    public static final String OIDC_LOGIN_HINT_NAME = "userName";
    public static final String OIDC_LOGIN_HINT_EMAIL = "userEmail";
    public static final String OIDC_LOGIN_TYPE = "type";
    public static final String OIDC_LOGIN_CUSTOM = "custom";
    public static final String OIDC_LTI_MESSAGE_HINT = "lti_message_hint";
    public static final String OIDC_INITIATION_URI = "oidc_initiation_URL";
    public static final String OIDC_TARGET_LINK_URI = "target_link_uri";
    public static final String OIDC_CLIENT_ID = "client_id";
    public static final String OIDC_DEPLOYMENT_ID = "lti_deployment_id";

    //Those are used by the session.
    public static final String LTI_SESSION_USER_ID = "user_id";
    public static final String LTI_SESSION_USER_ROLE = "user_role";
    public static final String LTI_SESSION_CONTEXT_ID = "context_id";
    public static final String LTI_SESSION_DEPLOYMENT_KEY = "deployment_key";
    

    
    
    //BASICS
    public static final String ISS_VALUE = "https://www.carnegielearning.com";	
    public static final String LTI_MESSAGE_TYPE = "https://purl.imsglobal.org/spec/lti/claim/message_type";
    public static final String LTI_VERSION = "https://purl.imsglobal.org/spec/lti/claim/version";
    public static final String LTI_DEPLOYMENT_ID = "https://purl.imsglobal.org/spec/lti/claim/deployment_id";
    public static final String LTI_DATA = "https://purl.imsglobal.org/spec/lti-dl/claim/data";
    public static final String LTI_CONTENT_ITEMS = "https://purl.imsglobal.org/spec/lti-dl/claim/content_items";

    //RESOURCE_LINK
    public static final String LTI_LINK = "https://purl.imsglobal.org/spec/lti/claim/resource_link";
    public static final String LTI_LINK_ID = "id";
    public static final String LTI_LINK_DESC = "description";
    public static final String LTI_LINK_TITLE = "title";

    //ROLES
    public static final String LTI_ROLES = "https://purl.imsglobal.org/spec/lti/claim/roles";
    public static final String LTI_ROLE_SCOPE_MENTOR = "https://purl.imsglobal.org/spec/lti/claim/role_scope_mentor";
    //ROLES INSTITUTION
    public static final String LTI_ROLE_STUDENT = "http://purl.imsglobal.org/vocab/lis/v2/institution/person#Student";
    public static final String LTI_ROLE_LEARNER = "http://purl.imsglobal.org/vocab/lis/v2/institution/person#Learner";
    public static final String LTI_ROLE_MENTOR = "http://purl.imsglobal.org/vocab/lis/v2/institution/person#Mentor";
    public static final String LTI_ROLE_INSTRUCTOR = "http://purl.imsglobal.org/vocab/lis/v2/institution/person#Instructor";
    public static final String LTI_ROLE_GUEST = "http://purl.imsglobal.org/vocab/lis/v2/institution/person#Guest";
    public static final String LTI_ROLE_OTHER = "http://purl.imsglobal.org/vocab/lis/v2/institution/person#Other";
    public static final String LTI_ROLE_STAFF = "http://purl.imsglobal.org/vocab/lis/v2/institution/person#Staff";
    public static final String LTI_ROLE_ALUMNI = "http://purl.imsglobal.org/vocab/lis/v2/institution/person#Alumni";
    public static final String LTI_ROLE_FACULTY = "http://purl.imsglobal.org/vocab/lis/v2/institution/person#Faculty";
    public static final String LTI_ROLE_MEMBER = "http://purl.imsglobal.org/vocab/lis/v2/institution/person#Member";
    public static final String LTI_ROLE_OBSERVER = "http://purl.imsglobal.org/vocab/lis/v2/institution/person#Observer";
    public static final String LTI_ROLE_PROSPECTIVE_STUDENT = "http://purl.imsglobal.org/vocab/lis/v2/institution/person#ProspectiveStudent";
    public static final String LTI_ROLE_ADMIN = "http://purl.imsglobal.org/vocab/lis/v2/institution/person#Administrator";
    //ROLES MEMBERSHIP
    //TODO Each of these has several sub-roles. Maybe it is better just to keep in the constant the "prefix" and find the role with the suffix(es)
    public static final String LTI_ROLE_MEMBERSHIP_ADMIN = "http://purl.imsglobal.org/vocab/lis/v2/membership#Administrator";
    public static final String LTI_ROLE_MEMBERSHIP_CONTENT_DEVELOPER = "http://purl.imsglobal.org/vocab/lis/v2/membership#ContentDeveloper";
    public static final String LTI_ROLE_MEMBERSHIP_INSTRUCTOR = "http://purl.imsglobal.org/vocab/lis/v2/membership#Instructor";
    public static final String LTI_ROLE_MEMBERSHIP_LEARNER = "http://purl.imsglobal.org/vocab/lis/v2/membership#Learner";
    public static final String LTI_ROLE_MEMBERSHIP_MENTOR = "http://purl.imsglobal.org/vocab/lis/v2/membership#Mentor";
    public static final String LTI_ROLE_MEMBERSHIP_MANAGER = "http://purl.imsglobal.org/vocab/lis/v2/membership#Manager";
    public static final String LTI_ROLE_MEMBERSHIP_MEMBER = "http://purl.imsglobal.org/vocab/lis/v2/membership#Member";
    public static final String LTI_ROLE_MEMBERSHIP_OFFICER = "http://purl.imsglobal.org/vocab/lis/v2/membership#Officer";
    //ROLES SYSTEM
    public static final String LTI_ROLE_SYS_ADMINISTRATOR = "http://purl.imsglobal.org/vocab/lis/v2/system/person#Administrator";
    public static final String LTI_ROLE_NONE = "http://purl.imsglobal.org/vocab/lis/v2/system/person#None";
    public static final String LTI_ROLE_GENERAL = "http://purl.imsglobal.org/vocab/lis/v2/system/person#User";
    public static final String LTI_ROLE_ACCOUNT_ADMIN = "http://purl.imsglobal.org/vocab/lis/v2/system/person#AccountAdmin";
    public static final String LTI_ROLE_CREATOR = "http://purl.imsglobal.org/vocab/lis/v2/system/person#Creator";
    public static final String LTI_ROLE_SYS_ADMIN = "http://purl.imsglobal.org/vocab/lis/v2/system/person#SysAdmin";
    public static final String LTI_ROLE_SYS_SUPPORT = "http://purl.imsglobal.org/vocab/lis/v2/system/person#SysSupport";

    //CONTEXT
    public static final String LTI_CONTEXT = "https://purl.imsglobal.org/spec/lti/claim/context";
    public static final String LTI_CONTEXT_ID = "id";
    public static final String LTI_CONTEXT_TYPE = "type";
    public static final String LTI_CONTEXT_LABEL = "label";
    public static final String LTI_CONTEXT_TITLE = "title";
    public static final String LTI_CONTEXT_TYPE_COURSE_TEMPLATE = "http://purl.imsglobal.org/vocab/lis/v2/course#CourseTemplate";
    public static final String LTI_CONTEXT_TYPE_COURSE_OFFERING = "http://purl.imsglobal.org/vocab/lis/v2/course#CourseOffering";
    public static final String LTI_CONTEXT_TYPE_COURSE_SECTION = "http://purl.imsglobal.org/vocab/lis/v2/course#CourseSection";
    public static final String LTI_CONTEXT_TYPE_GROUP = "http://purl.imsglobal.org/vocab/lis/v2/course#Group";

    //PLATFORM
    public static final String LTI_PLATFORM = "https://purl.imsglobal.org/spec/lti/claim/tool_platform";
    public static final String LTI_PLATFORM_GUID = "guid";
    public static final String LTI_PLATFORM_CONTACT_EMAIL = "contact_email";
    public static final String LTI_PLATFORM_DESC = "description";
    public static final String LTI_PLATFORM_NAME = "name";
    public static final String LTI_PLATFORM_URL = "url";
    public static final String LTI_PLATFORM_PRODUCT = "product_family_code";
    public static final String LTI_PLATFORM_PRODUCT_FAMILY_CODE = "product_family_code";
    public static final String LTI_PLATFORM_VERSION = "version";

    //LAUNCH_PRESENTATION
    public static final String LTI_LAUNCH_PRESENTATION = "https://purl.imsglobal.org/spec/lti/claim/launch_presentation";
    public static final String LTI_PRES_TARGET = "document_target";
    public static final String LTI_PRES_WIDTH = "width";
    public static final String LTI_PRES_HEIGHT = "height";
    public static final String LTI_PRES_RETURN_URL = "return_url";
    public static final String LTI_PRES_LOCALE = "locale";
    public static final String LTI_PRES_RETURN_URL_PARAMETER_ERROR_MSG = "_ltierrormsg";
    public static final String LTI_PRES_RETURN_URL_PARAMETER_MSG = "_ltimsg";
    public static final String LTI_PRES_RETURN_URL_PARAMETER_ERROR_LOG = "_ltierrorlog";
    public static final String LTI_PRES_RETURN_URL_PARAMETER_LOG = "_ltilog";
   

    //LIS
    public static final String LTI_LIS = "https://purl.imsglobal.org/spec/lti/claim/lis";
    public static final String LTI_PERSON_SOURCEDID = "person_sourcedid";
    public static final String LTI_COURSE_OFFERING_SOURCEDID = "course_offering_sourcedid";
    public static final String LTI_COURSE_SECTION_SOURCEDID = "course_section_sourcedid";

    //CUSTOM AND EXTENSION TEST
    public static final String LTI_EXTENSION = "https://www.example.com/extension";
    public static final String LTI_CUSTOM = "https://purl.imsglobal.org/spec/lti/claim/custom";
    public static final String LTI_CLASS_GUID = "classGuid";
    public static final String LTI_TARGET_USER_ID = "targetUserId";
    public static final String LTI_ENCOUNTER_ID = "encounterId";
    public static final String LTI_LAUNCH_TYPE = "launchType";
    public static final String LTI_ASSET_ID = "assetId";
    
    
    //OTHERS
    public static final String LTI_NAME = "name";
    public static final String LTI_GIVEN_NAME = "given_name";
    public static final String LTI_FAMILY_NAME = "family_name";
    public static final String LTI_MIDDLE_NAME = "middle_name";
    public static final String LTI_PICTURE = "picture";
    public static final String LTI_EMAIL = "email";
    public static final String LTI_LOCALE = "locale";
    public static final String LTI_AZP = "azp";
    public static final String LTI_ENDPOINT = "https://purl.imsglobal.org/spec/lti-ags/claim/endpoint";
    public static final String LTI_ENDPOINT_SCOPE = "scope";
    public static final String LTI_ENDPOINT_SCOPE_SCORE = "https://purl.imsglobal.org/spec/lti-ags/scope/score";
    public static final String LTI_ENDPOINT_SCOPE_LINE_ITEM = "https://purl.imsglobal.org/spec/lti-ags/scope/lineitem";    
    public static final String LTI_ENDPOINT_LINEITEMS = "lineitems";
    public static final String LTI_ENDPOINT_LINEITEM = "lineitem";    
    public static final String LTI_NAMES_ROLE_SERVICE = "https://purl.imsglobal.org/spec/lti-nrps/claim/namesroleservice";
    public static final String LTI_NAMES_ROLE_SERVICE_CONTEXT = "context_memberships_url";
    public static final String LTI_NAMES_ROLE_SERVICE_VERSIONS = "service_versions";
    public static final String LTI_STATE = "state";
    public static final String LTI_METHOD = "method";
    public static final String LTI_TARGET_LINK_URL = "target_link_URL";
    public static final String LTI_PLATFORM_Key = "platformKey";
    public static final String LTI_ISSUER = "issuer";
    public static final String LTI_IAT = "iat";
    public static final String LTI_AUD = "aud";
    public static final String LTI_SUB = "sub";
    public static final String LTI_ISS = "iss";
    public static final String LTI_JTI = "jti";
    public static final String LTI_EXP = "exp";
    
    public static final String LTI_EXP_TIME_IN_MINUTES = "exp_time_in_minutes";
    public static final String LTI_ACCEPTABLE_TOKEN_GENERATION_TIME_IN_SECONDS = "acceptable_token_generation_time_in_seconds";
    public static final String LTI_TOOL_JWKS_URL = "tool_jwks_url";
    public static final String LTI_PLATFORM_JWKS_URL = "platform_jwks_url";    
    public static final String LTI_SIGNATURE_ALGORITHM = "signature_algorithm";
    
      
    public static final String LTI_CALIPER_ENDPOINT_SERVICE = "https://purl.imsglobal.org/spec/lti-ces/claim/caliper-endpoint-service";
    public static final String LTI_CALIPER_ENDPOINT_SERVICE_SCOPES = "scopes";
    public static final String LTI_CALIPER_ENDPOINT_SERVICE_URL = "caliper_endpoint_url";
    public static final String LTI_CALIPER_ENDPOINT_SERVICE_SESSION_ID = "caliper_federated_session_id";

    public static final String LTI_11_LEGACY_USER_ID = "https://purl.imsglobal.org/spec/lti/claim/lti11_legacy_user_id";
    public static final String LTI_NONCE = "nonce";

    public static final String LTI_CONSUMER_KEY = "oauth_consumer_key";

    public static final String LTI_MESSAGE_TYPE_RESOURCE_LINK = "LtiResourceLinkRequest";
    public static final String LTI_MESSAGE_TYPE_DEEP_LINKING = "LtiDeepLinkingRequest";
    public static final String LTI_MESSAGE_TYPE_DEEP_LINKING_RESPONSE = "LtiDeepLinkingResponse";
    public static final String LTI_VERSION_3 = "1.3.0";
    public static final String LTI_TARGET_LINK_URI = "https://purl.imsglobal.org/spec/lti/claim/target_link_uri";

    public static final String DEEP_LINKING_SETTINGS = "https://purl.imsglobal.org/spec/lti-dl/claim/deep_linking_settings";
    public static final String DEEP_LINK_RETURN_URL = "deep_link_return_url";
    public static final String DEEP_LINK_ACCEPT_TYPES = "accept_types";
    public static final String DEEP_LINK_ACCEPT_MEDIA_TYPES = "accept_media_types";
    public static final String DEEP_LINK_DOCUMENT_TARGETS = "accept_presentation_document_targets";
    public static final String DEEP_LINK_ACCEPT_MULTIPLE = "accept_multiple";
    public static final String DEEP_LINK_AUTO_CREATE = "auto_create";
    public static final String DEEP_LINK_TITLE = "title";
    public static final String DEEP_LINK_TEXT = "text";
    public static final String DEEP_LINK_DATA = "data";
    public static final String DEEP_LINK_LTIRESOURCELINK = "ltiResourceLink";
    public static final String DEEP_LINK_TYPE = "type";
    public static final String DEEP_LINK_URL = "url";

    public static final String KID = "kid";
    public static final String ALG = "alg";
    public static final String TYP = "typ";
    public static final String JWT = "JWT";
    public static final String RS256 = "RS256";
    public static final String TOOL_KID = "tool_kid";
    public static final String PLATFORM_KID = "platform_kid";

    public static final List<String> LTI_OPTIONAL_CLAIMS = Arrays.asList(LTI_CONTEXT, LTI_PLATFORM, LTI_LAUNCH_PRESENTATION, LTI_LIS, LTI_ROLE_SCOPE_MENTOR, LTI_CUSTOM);

    //Dynamic Registration
    public static final String REGISTRATION_TOKEN = "registration_token";
    public static final String REGISTRATION_ID = "registration_id";
    public static final String PLATFORM_CONFIGURATION = "platform_configuration";
    public static final String TOOL_CONFIGURATION = "tool_configuration";
    public static final String RESOURCE_MESSAGE_TYPE = "LtiResourceLinkRequest";
    public static final String DEEP_LINKING_MESSAGE_TYPE = "LtiDeepLinkingRequest";
    public static final List<String> MESSAGES_SUPPORTED_TYPES = Arrays.asList(RESOURCE_MESSAGE_TYPE, DEEP_LINKING_MESSAGE_TYPE);

    //Assignments & Grades Service (AGS)
    public static final String ACTIVITY_PROGRESS_INITIALIZED = "Initialized";
    public static final String ACTIVITY_PROGRESS_STARTED = "Started";
    public static final String ACTIVITY_PROGRESS_IN_PROGRESS = "InProgress";
    public static final String ACTIVITY_PROGRESS_SUBMITTED = "Submitted";
    public static final String ACTIVITY_PROGRESS_COMPLETED = "Completed";
    public static final String GRADING_PROGRESS_FULLY_GRADED = "FullyGraded";
    public static final String GRADING_PROGRESS_PENDING = "Pending";
    public static final String GRADING_PROGRESS_PENDING_MANUAL = "PendingManual";
    public static final String GRADING_PROGRESS_FAILED = "Failed";
    public static final String GRADING_PROGRESS_NOT_READY = "NotReady";
    public static final String AG_CALLBACK_URL = "ag_callback_URL";
}