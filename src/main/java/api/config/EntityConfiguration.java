package api.config;

import services.*;

public enum EntityConfiguration {

    USER {
        @Override
        public Class<?> getEntityService() {
            return UserService.class;
        }

    },
    RESPONSE_HEADERS {
        @Override
        public Class<?> getEntityService() {
            return ResponseHeadersService.class;
        }
    },
    AVERAGE_DURATION {
        @Override
        public Class<?> getEntityService() {
            return AverageDurationService.class;
        }
    },
    TOKEN{
        @Override
        public Class<?> getEntityService() { return DoTokenService.class; }
    };
    public abstract Class<?> getEntityService();
}
