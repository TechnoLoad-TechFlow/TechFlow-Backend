package com.technoload.techflow.platform.subscription.application.commandservices;

import com.technoload.techflow.platform.shared.application.result.ApplicationError;
import com.technoload.techflow.platform.shared.application.result.Result;
import com.technoload.techflow.platform.subscription.domain.model.aggregates.Subscription;
import com.technoload.techflow.platform.subscription.domain.model.commands.ActivateSubscriptionCommand;
import com.technoload.techflow.platform.subscription.domain.model.commands.CancelSubscriptionCommand;
import com.technoload.techflow.platform.subscription.domain.model.commands.ConfirmCheckoutCommand;
import com.technoload.techflow.platform.subscription.domain.model.commands.SubscribeToPlanCommand;

/**
 * Command service port for Subscription Management.
 */
public interface SubscriptionManagementCommandService {

    Result<Subscription, ApplicationError> handle(SubscribeToPlanCommand command);

    Result<Subscription, ApplicationError> handle(ConfirmCheckoutCommand command);

    Result<Subscription, ApplicationError> handle(ActivateSubscriptionCommand command);

    Result<Subscription, ApplicationError> handle(CancelSubscriptionCommand command);
}
