/* See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * Esri Inc. licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.esri.gpt.framework.http.crawl;

import java.util.LinkedList;

/**
 * Crawl flag manager.
 */
class CrawlFlagManager {
  private final LinkedList<CrawlFlag> crawlFlags = new LinkedList<CrawlFlag>();
  
  /**
   * Create new flag.
   * @return flag
   */
  public synchronized CrawlFlag newFlag() {
    CrawlFlag flag = new CrawlFlag();
    crawlFlags.push(flag);
    return flag;
  }
  
  /**
   * Notify last in the queue.
   */
  public synchronized void notifyLast() {
    if (!crawlFlags.isEmpty()) {
      crawlFlags.pop().set();
    }
  }
}
