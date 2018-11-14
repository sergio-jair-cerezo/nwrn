//
//  SideMenuExternalManagerBridge.m
//  NWRN
//
//  Created by Sergio Jair Cerezo Vallejo on 11/13/18.
//  Copyright © 2018 Sergio Jair Cerezo Vallejo. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "React/RCTBridgeModule.h"

@interface RCT_EXTERN_MODULE(SideMenuExternalManager, NSObject)

RCT_EXTERN_METHOD(openMenuFromJS)
RCT_EXTERN_METHOD(showHighScoresResultFromJS:)

@end
