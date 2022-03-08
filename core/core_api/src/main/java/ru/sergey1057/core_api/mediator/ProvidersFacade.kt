package ru.sergey1057.core_api.mediator

import ru.sergey1057.core_api.network.NetworkProvider

interface ProvidersFacade : MediatorsProvider, AppProvider, NetworkProvider