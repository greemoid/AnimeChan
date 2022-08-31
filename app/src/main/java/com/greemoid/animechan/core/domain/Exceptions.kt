package com.greemoid.animechan.core.domain

import java.io.IOException

class ServiceUnavailableException() : IOException()
class NoConnectionException() : IOException()
class NoCachedDataException() : IOException()