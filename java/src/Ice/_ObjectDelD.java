// **********************************************************************
//
// Copyright (c) 2003-2007 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

package Ice;

public class _ObjectDelD implements _ObjectDel
{
    public boolean
    ice_isA(final String __id, java.util.Map __context)
        throws IceInternal.LocalExceptionWrapper
    {
        final Current __current = new Current();
        __initCurrent(__current, "ice_isA", OperationMode.Nonmutating, __context);
        
        final BooleanHolder __result = new BooleanHolder();

        IceInternal.Direct __direct = null;
        try
        {
            __direct = new IceInternal.Direct(__current)
            {
                public DispatchStatus run(Ice.Object __servant)
                {
                    __result.value = __servant.ice_isA(__id, __current);
                    return DispatchStatus.DispatchOK;
                }
            };
        }
        catch(Throwable __ex)
        {
            IceInternal.LocalExceptionWrapper.throwUnknownWrapper(__ex);
        }
        
        try
        {
            DispatchStatus __status = __direct.servant().__collocDispatch(__direct); 
            assert __status == DispatchStatus.DispatchOK;
            return __result.value;
        }
        catch(java.lang.Throwable __ex)
        {
            IceInternal.LocalExceptionWrapper.throwUnknownWrapper(__ex);
        }
        finally
        {
            try
            {
                __direct.destroy();
            }
            catch(Throwable __ex)
            {
                IceInternal.LocalExceptionWrapper.throwUnknownWrapper(__ex);
            }
        }
        return false; // Keep compiler happy.
    }

    public void
    ice_ping(java.util.Map __context)
        throws IceInternal.LocalExceptionWrapper
    {
        final Current __current = new Current();
        __initCurrent(__current, "ice_ping", OperationMode.Nonmutating, __context);
       
        IceInternal.Direct __direct = null;
        try
        {
            __direct = new IceInternal.Direct(__current)
            {
                public DispatchStatus run(Ice.Object __servant)
                {
                    __servant.ice_ping(__current);
                    return DispatchStatus.DispatchOK;
                }
            };
        }
        catch(Ice.UserException __ex)
        {
            throw new IceInternal.LocalExceptionWrapper(new Ice.UnknownUserException(__ex.toString()), false);
        }
                
        try
        {
            DispatchStatus __status = __direct.servant().__collocDispatch(__direct); 
            assert __status == DispatchStatus.DispatchOK;
        }
        catch(Throwable __ex)
        {
            IceInternal.LocalExceptionWrapper.throwUnknownWrapper(__ex);
        }
        finally
        {
            try
            {
                __direct.destroy();
            }
            catch(Throwable __ex)
            {
                IceInternal.LocalExceptionWrapper.throwUnknownWrapper(__ex);
            }
        }
    }

    public String[]
    ice_ids(java.util.Map __context)
        throws IceInternal.LocalExceptionWrapper
    {
        final Current __current = new Current();
        __initCurrent(__current, "ice_ids", OperationMode.Nonmutating, __context);

        final Ice.StringSeqHolder __result = new Ice.StringSeqHolder();

        IceInternal.Direct __direct = null;
        try
        {
            __direct = new IceInternal.Direct(__current)
            {

                public DispatchStatus run(Ice.Object __servant)
                {
                    __result.value = __servant.ice_ids(__current);
                    return DispatchStatus.DispatchOK;
                }
            };
        }
        catch(Throwable __ex)
        {
            IceInternal.LocalExceptionWrapper.throwUnknownWrapper(__ex);
        }

        try
        {
            DispatchStatus __status = __direct.servant().__collocDispatch(__direct); 
            assert __status == DispatchStatus.DispatchOK;
            return __result.value;
        }
        catch(Throwable __ex)
        {
            IceInternal.LocalExceptionWrapper.throwUnknownWrapper(__ex);
        }
        finally
        {
            try
            {
                __direct.destroy();
            }
            catch(Throwable __ex)
            {
                IceInternal.LocalExceptionWrapper.throwUnknownWrapper(__ex);
            }
        }
        return __result.value; // Keep compiler happy.
    }

    public String
    ice_id(java.util.Map __context)
        throws IceInternal.LocalExceptionWrapper
    {
        final Current __current = new Current();
        __initCurrent(__current, "ice_id", OperationMode.Nonmutating, __context);
        
        final Ice.StringHolder __result = new Ice.StringHolder();

        IceInternal.Direct __direct = null;
        try
        {
            __direct = new IceInternal.Direct(__current)
            {
                public DispatchStatus run(Ice.Object __servant)
                {
                    __result.value = __servant.ice_id(__current);
                    return DispatchStatus.DispatchOK;
                }
            };
        }
        catch(Throwable __ex)
        {
            IceInternal.LocalExceptionWrapper.throwUnknownWrapper(__ex);
        }

        try
        {
            DispatchStatus __status = __direct.servant().__collocDispatch(__direct); 
            assert __status == DispatchStatus.DispatchOK;
            return __result.value;
        }
        catch(Throwable __ex)
        {
            IceInternal.LocalExceptionWrapper.throwUnknownWrapper(__ex);
        }
        finally
        {
            try
            {
                __direct.destroy();
            }
            catch(Throwable __ex)
            {
                IceInternal.LocalExceptionWrapper.throwUnknownWrapper(__ex);
            }
        }
        return __result.value; // Keep compiler happy.
    }

    public boolean
    ice_invoke(String operation, Ice.OperationMode mode, byte[] inParams, ByteSeqHolder outParams,
               java.util.Map context)
    {
        throw new CollocationOptimizationException();
    }

    public ConnectionI
    __getConnection(BooleanHolder compress)
    {
        throw new CollocationOptimizationException();
    }

    //
    // Only for use by ObjectPrx.
    //
    final void
    __copyFrom(_ObjectDelD from)
    {
        //
        // No need to synchronize "from", as the delegate is immutable
        // after creation.
        //

        //
        // No need to synchronize, as this operation is only called
        // upon initialization.
        //

        assert(__reference == null);
        assert(__adapter == null);

        __reference = from.__reference;
        __adapter = from.__adapter;
    }

    protected IceInternal.Reference __reference;
    protected Ice.ObjectAdapter __adapter;

    protected final void
    __initCurrent(Current current, String op, Ice.OperationMode mode, java.util.Map context)
    {
        current.adapter = __adapter;
        current.id = __reference.getIdentity();
        current.facet = __reference.getFacet();
        current.operation = op;
        current.mode = mode;

        if(context != null)
        {
            current.ctx = context;
        }
        else
        {
            //
            // Implicit context
            //
            ImplicitContextI implicitContext =
                __reference.getInstance().getImplicitContext();
            
            java.util.Map prxContext = __reference.getContext();
            
            if(implicitContext == null)
            {
                current.ctx = new java.util.HashMap(prxContext);
            }
            else
            {
                current.ctx = implicitContext.combine(prxContext);
            }
        }
        current.requestId = -1;
    }

    public void
    setup(IceInternal.Reference ref, Ice.ObjectAdapter adapter)
    {
        //
        // No need to synchronize, as this operation is only called
        // upon initialization.
        //

        assert(__reference == null);
        assert(__adapter == null);

        __reference = ref;
        __adapter = adapter;
    }
}
