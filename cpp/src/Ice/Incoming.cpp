// **********************************************************************
//
// Copyright (c) 2001
// MutableRealms, Inc.
// Huntsville, AL, USA
//
// All Rights Reserved
//
// **********************************************************************

#include <Ice/Incoming.h>
#include <Ice/ObjectAdapter.h>
#include <Ice/Object.h>
#include <Ice/LocalException.h>

using namespace std;
using namespace Ice;
using namespace IceInternal;

IceInternal::Incoming::Incoming(const InstancePtr& instance, const ObjectAdapterPtr& adapter) :
    _adapter(adapter),
    _is(instance),
    _os(instance)
{
}

IceInternal::Incoming::~Incoming()
{
}

void
IceInternal::Incoming::invoke(Stream& is)
{
    _is.swap(is);
    string identity;
    _is.read(identity);
    string operation;
    _is.read(operation);

    int statusPos = _os.b.size();
    _os.write(Byte(0));

    ObjectPtr object = _adapter->identityToObject(identity);

    ObjectLocatorPtr locator;
    ObjectPtr cookie;
    if (object)
    {
	locator = _adapter->getObjectLocator();
	if (locator)
	{
	    object = locator->locate(_adapter, identity, cookie);
	}
    }

    if(!object)
    {
	*(_os.b.begin() + statusPos) = static_cast<Byte>(DispatchObjectNotExist);
	return;
    }

    try
    {
	DispatchStatus status = object->__dispatch(*this, operation);
	if (status != DispatchOK && status != DispatchException && status != DispatchOperationNotExist)
	{
	    throw UnknownReplyStatusException(__FILE__, __LINE__);
	}
	
	*(_os.b.begin() + statusPos) = static_cast<Byte>(status);
    }
    catch(const LocationForward& p)
    {
	*(_os.b.begin() + statusPos) = static_cast<Byte>(DispatchLocationForward);
	write(&_os, p._prx);
    }

    if (locator)
    {
	locator->finished(_adapter, identity, object, cookie);
    }
}

Stream*
IceInternal::Incoming::is()
{
    return &_is;
}

Stream*
IceInternal::Incoming::os()
{
    return &_os;
}
