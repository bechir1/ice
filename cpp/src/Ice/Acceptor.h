// **********************************************************************
//
// Copyright (c) 2002
// MutableRealms, Inc.
// Huntsville, AL, USA
//
// All Rights Reserved
//
// **********************************************************************

#ifndef ICE_ACCEPTOR_H
#define ICE_ACCEPTOR_H

#include <Ice/AcceptorF.h>
#include <Ice/TransceiverF.h>
#include <Ice/Shared.h>

namespace IceInternal
{

class Acceptor : public Shared
{
public:

    virtual int fd() = 0;
    virtual void close() = 0;
    virtual void shutdown() = 0;
    virtual void listen() = 0;
    virtual TransceiverPtr accept(int) = 0;
    virtual std::string toString() const = 0;

protected:

    Acceptor() { }
    virtual ~Acceptor() { }
};

}

#endif
